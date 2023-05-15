package vn.edu.nlu.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.edu.nlu.entity.Appointment;
import vn.edu.nlu.entity.Booking;
import vn.edu.nlu.entity.Doctor;
import vn.edu.nlu.entity.Patient;
import vn.edu.nlu.payload.request.BookingRequest;
import vn.edu.nlu.repository.BookingRepository;
import vn.edu.nlu.repository.DoctorRepository;
import vn.edu.nlu.repository.PatientRepository;
import vn.edu.nlu.service.IBookingService;

import java.util.*;

@Component
public class BookingService implements IBookingService {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;


    @Override
    public List<Booking> getAllListBooking() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> getListBookingDoctorById(int id) {
        return bookingRepository.findByDoctor_id(id);
    }

    @Override
    public List<Booking> getListBookingPatientById(int id) {
        return bookingRepository.findByPatient_id(id);
    }

    @Override
    public String addBooking(BookingRequest request) {
        if (!validateDateBooking(request)) return "This time slot is already registered";

        try{
            Doctor doctor = doctorRepository.findById(request.getDoctorId()).get();
            Patient patient = patientRepository.findById(request.getPatientId()).get();
            Date endTime = new Date(request.getDateBooking().getTime() + Booking.DURATION);
            Booking booking = Booking.builder()
                    .patientName(request.getFullName())
                    .patientPhone(request.getPhone())
                    .patientGender(request.getGender())
                    .patientEmail(request.getEmail())
                    .dateBooking(request.getDateBooking())
                    .dateEnd(endTime)
                    .doctor(doctor)
                    .patient(patient)
                    .description(request.getDescription())
                    .build();
            bookingRepository.save(booking);
        }catch (NoSuchElementException e){
            return "can not define doctor ";
        }

        return "booking success";
    }

    public boolean validateDateBooking(BookingRequest request){
        List<Booking> doctorBookingList = getListBookingDoctorById(request.getDoctorId());
        Date endTime = new Date(request.getDateBooking().getTime() + Booking.DURATION);

        for (Booking booking : doctorBookingList){
            Date dateBooking = booking.getDateBooking();
            if (isDateBetween(dateBooking,request.getDateBooking(),endTime)){
                return false;
            }
        }
        return true;
    }
    public static boolean isDateBetween(Date dateToCheck, Date startDate, Date endDate) {
        return dateToCheck.compareTo(startDate) >= 0 && dateToCheck.compareTo(endDate) <= 0;
    }
}
