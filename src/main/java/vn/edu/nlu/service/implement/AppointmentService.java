package vn.edu.nlu.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.edu.nlu.entity.Appointment;
import vn.edu.nlu.repository.AppointmentRepository;
import vn.edu.nlu.service.IAppointmentService;

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
}
