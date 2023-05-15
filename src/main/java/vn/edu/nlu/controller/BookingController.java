package vn.edu.nlu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.nlu.entity.Booking;
import vn.edu.nlu.payload.request.BookingRequest;
import vn.edu.nlu.repository.BookingRepository;
import vn.edu.nlu.service.IBookingService;
import vn.edu.nlu.service.implement.BookingService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    IBookingService bookingService;

    @GetMapping("/doctor/{id}")
    public List<Booking> getListAppointmentByDoctorId(@PathVariable int id){
        return  bookingService.getListBookingDoctorById(id);
    }
    @GetMapping("/patient/{id}")
    public List<Booking> getListAppointmentByPatientId(@PathVariable int id){
        return  bookingService.getListBookingPatientById(id);
    }

    @PostMapping
    public String addBooking(@RequestBody BookingRequest request){
        return bookingService.addBooking(request);
    }
}
