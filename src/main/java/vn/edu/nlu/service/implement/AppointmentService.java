package vn.edu.nlu.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.edu.nlu.entity.Appointment;
import vn.edu.nlu.exception.ServiceException;
import vn.edu.nlu.payload.respose.AppointmentResponse;
import vn.edu.nlu.repository.AppointmentRepository;
import vn.edu.nlu.service.IAppointmentService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class AppointmentService implements IAppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> getAllListAppointment() {
        return appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> getListAppointmentDoctorById(int id) {
        return appointmentRepository.findByDoctor_id(id);
    }

    @Override
    public List<Appointment> getListAppointmentPatientById(int id) {
        return appointmentRepository.findByPatient_id(id);
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
                    appointmentResponse.setDateEnd(appointment.getDateENd());
                    responseList.add(appointmentResponse);
                }
            }
            return responseList;
        } catch (Exception exception) {
            throw new ServiceException("Đã xảy ra lỗi, vui lòng kiểm tra lại!");
        }
    }
}
