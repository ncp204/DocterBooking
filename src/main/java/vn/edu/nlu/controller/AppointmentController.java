package vn.edu.nlu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.nlu.dto.AppointmentDto;
import vn.edu.nlu.exception.ServiceException;
import vn.edu.nlu.payload.request.BookingRequest;
import vn.edu.nlu.payload.respose.AppointmentResponse;
import vn.edu.nlu.service.implement.AppointmentService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/doctor/{id}")
    public List<AppointmentDto> getListAppointmentByDoctorId(@PathVariable int id) {
        return appointmentService.getListAppointmentDoctorById(id);
    }

    @GetMapping("/patient/{id}")
    public List<AppointmentDto> getListAppointmentByPatientId(@PathVariable int id) {
        return appointmentService.getListAppointmentPatientById(id);
    }

    @GetMapping("/doctor/date")
    public List<AppointmentResponse> getListAppointmentDoctorByDate(@RequestParam("id") int id, @RequestParam("date") String dateString) {
        try {
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            Date date = dateFormat.parse(dateString);
            return appointmentService.getListAppointmentByDate(id, date);
        } catch (ParseException e) {
            throw new ServiceException("Định dạng ngày không hợp lệ");
        }
    }
    @PostMapping
    public String addBooking(@RequestBody BookingRequest request){
        return appointmentService.addBooking(request);
    }
}
