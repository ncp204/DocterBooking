package vn.edu.nlu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.nlu.dto.AppointmentDto;
import vn.edu.nlu.entity.Appointment;
import vn.edu.nlu.exception.ServiceException;
import vn.edu.nlu.payload.request.AppointmentRequest;
import vn.edu.nlu.payload.request.BookingRequest;
import vn.edu.nlu.payload.respose.AppointmentResponse;
import vn.edu.nlu.service.implement.AppointmentService;

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
    public List<AppointmentResponse> getListAppointmentDoctorByDate(@RequestBody AppointmentRequest request) {
        return appointmentService.getListAppointmentByDate(request.getId(), request.getDateBooking());
    }
    @PostMapping
    public String addBooking(@RequestBody BookingRequest request){
        return appointmentService.addBooking(request);
    }

    @GetMapping("/detail/{id}")
    public AppointmentDto getListAppointmentDetailById(@PathVariable int id) {
        return appointmentService.getAppointmentDetailById(id);
    }
}
