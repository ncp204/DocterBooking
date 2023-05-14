package vn.edu.nlu.service;

import org.springframework.stereotype.Service;
import vn.edu.nlu.entity.Appointment;
import vn.edu.nlu.entity.Booking;

import java.util.List;

@Service
public interface IBookingService {
    public List<Booking> getAllListBooking();
    public List<Booking> getListBookingDoctorById(int id);
    public List<Booking> getListBookingPatientById(int id);
}
