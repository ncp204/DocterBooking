package vn.edu.nlu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.nlu.entity.Appointment;
import vn.edu.nlu.service.implement.AppointmentService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/doctor/{id}")
    public List<Appointment> getListAppointmentByDoctorId(@PathVariable int id) {
        return appointmentService.getListAppointmentDoctorById(id);
    }

    @GetMapping("/patient/{id}")
    public List<Appointment> getListAppointmentByPatientId(@PathVariable int id) {
        return appointmentService.getListAppointmentPatientById(id);
    }

}
