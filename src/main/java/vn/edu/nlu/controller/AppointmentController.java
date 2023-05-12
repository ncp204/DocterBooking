package vn.edu.nlu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.nlu.entity2.Appointment;
import vn.edu.nlu.service2.implement.AppointmentService;

import java.util.List;

@RestController
@RequestMapping("/appointment")
@CrossOrigin(origins = "*")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/doctor/{id}")
    public List<Appointment> getListAppointmentByDoctorId(@PathVariable int id){
        return  appointmentService.getAppointmentByDoctorId(id);
    }
    @GetMapping("/patient/{id}")
    public List<Appointment> getListAppointmentByPatientId(@PathVariable int id){
        return  appointmentService.getAppointmentByPatientId(id);
    }
}
