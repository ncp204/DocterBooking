package vn.edu.nlu.service;

import org.springframework.stereotype.Service;
import vn.edu.nlu.entity.Appointment;

import java.util.List;

@Service
public interface IAppointmentService {
    public List<Appointment> getAllListAppointment();
    public List<Appointment> getListAppointmentDoctorById(int id);
    public List<Appointment> getListAppointmentPatientById(int id);
}
