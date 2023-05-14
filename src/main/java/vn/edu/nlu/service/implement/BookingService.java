package vn.edu.nlu.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.edu.nlu.entity.Appointment;
import vn.edu.nlu.entity.Booking;
import vn.edu.nlu.repository.BookingRepository;
import vn.edu.nlu.service.IBookingService;

import java.util.List;

@Component
public class BookingService implements IBookingService {
    @Autowired
    BookingRepository bookingRepository;


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
}
