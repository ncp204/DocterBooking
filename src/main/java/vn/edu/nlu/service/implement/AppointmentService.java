package vn.edu.nlu.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.edu.nlu.dto.AppointmentDto;
import vn.edu.nlu.dto.DoctorDetailDto;
import vn.edu.nlu.dto.Dtomapper;
import vn.edu.nlu.entity.Appointment;
import vn.edu.nlu.entity.Doctor;
import vn.edu.nlu.entity.Patient;
import vn.edu.nlu.exception.ServiceException;
import vn.edu.nlu.payload.request.BookingRequest;
import vn.edu.nlu.payload.respose.AppointmentResponse;
import vn.edu.nlu.repository.AppointmentRepository;
import vn.edu.nlu.repository.DoctorRepository;
import vn.edu.nlu.repository.PatientRepository;
import vn.edu.nlu.service.IAppointmentService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class AppointmentService implements IAppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;

    @Override
    public List<AppointmentDto> getAllListAppointment() {
        List<AppointmentDto> result = new ArrayList<>();
        List<Appointment> appointments = appointmentRepository.findAll();
        for (Appointment a:appointments) {
            AppointmentDto appointmentDto = Dtomapper.appointmentMap(a);
            result.add(appointmentDto);
        }


        return result;
    }

    @Override
    public List<AppointmentDto> getListAppointmentDoctorById(int id) {
        List<AppointmentDto> result = new ArrayList<>();
        List<Appointment> appointments = appointmentRepository.findByDoctor_id(id);
        for (Appointment a:appointments) {
            AppointmentDto appointmentDto = Dtomapper.appointmentMap(a);
            result.add(appointmentDto);
        }


        return result;

    }

    @Override
    public List<AppointmentDto> getListAppointmentPatientById(int id) {
        List<AppointmentDto> result = new ArrayList<>();
        List<Appointment> appointments = appointmentRepository.findByPatient_id(id);
        for (Appointment a:appointments) {
            AppointmentDto appointmentDto = Dtomapper.appointmentMap(a);
            result.add(appointmentDto);
        }


        return result;
    }

    @Override
    public List<AppointmentResponse> getListAppointmentByDate(int id, Date dateBooking){
        try {
            List<AppointmentResponse> responseList = new ArrayList<>();

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateBooking);

            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int month = calendar.get(Calendar.MONTH)+1;
            int year = calendar.get(Calendar.YEAR);
            List<Appointment> appointments = appointmentRepository.findByDoctorIdAndDate(id, year, month, day);

            AppointmentResponse appointmentResponse;
            if (appointments != null) {
                for (Appointment appointment : appointments) {
                    appointmentResponse = new AppointmentResponse();
                    appointmentResponse.setDateBooking(appointment.getDateBooking());
                    appointmentResponse.setDateEnd(appointment.getDateEnd());
                    appointmentResponse.setTimeBooking(appointment.getTimeBooking());
                    appointmentResponse.setTimeEnd(appointment.getTimeEnd());
                    responseList.add(appointmentResponse);
                }
            }
            return responseList;
        } catch (Exception exception) {
            throw new ServiceException("Đã xảy ra lỗi, vui lòng kiểm tra lại!");
        }
    }

    @Override
    public String addBooking(BookingRequest request) {
        if (!validateDateBooking(request)) return "This time slot is already registered";

        try{
            Doctor doctor = doctorRepository.findById(request.getDoctorId()).get();
            Patient patient = patientRepository.findById(request.getPatientId()).get();
            Appointment booking = Appointment.builder()
                    .patientName(request.getFullName())
                    .patientPhone(request.getPhone())
                    .patientGender(request.getGender())
                    .patientEmail(request.getEmail())
                    .dateBooking(request.getDateBooking())
                    .dateEnd(request.getDateBooking())
                    .timeBooking(request.getTimeBooking())
                    .timeEnd(request.getTimeBooking() + Appointment.DURATION)
                    .doctor(doctor)
                    .patient(patient)
                    .description(request.getDescription())
                    .build();
            appointmentRepository.save(booking);
        }catch (NoSuchElementException e){
            return "can not define doctor ";
        }

        return "booking success";
    }

    public boolean validateDateBooking(BookingRequest request){
        List<AppointmentDto> doctorAppointmentList = getListAppointmentDoctorById(request.getDoctorId());
        int timeBooking = request.getTimeBooking();

        for (AppointmentDto booking : doctorAppointmentList){
            Date dateBooking = booking.getDateBooking();
            SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
            boolean isSamedate = fmt.format(dateBooking).equals(fmt.format(request.getDateBooking()));
            System.out.println(isSamedate);
            if (isSamedate && (timeBooking == booking.getTimeBooking())){
                return false;
            }
        }
        return true;
    }
    public static boolean isDateBetween(Date dateToCheck, Date startDate, Date endDate) {
        return dateToCheck.compareTo(startDate) >= 0 && dateToCheck.compareTo(endDate) <= 0;
    }

    public AppointmentDto getAppointmentDetailById(int id){
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isEmpty()){
            return null;
        }
        AppointmentDto appointmentDto = Dtomapper.appointmentMap(appointment.get());
        return appointmentDto;
    }
}
