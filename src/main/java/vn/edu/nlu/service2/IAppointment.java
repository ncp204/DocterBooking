package vn.edu.nlu.service2;

import org.springframework.stereotype.Service;
import vn.edu.nlu.entity2.Appointment;

import java.util.List;

@Service
public interface IAppointment {
    public List<Appointment> getAllListAppointment();
    public List<Appointment> getListAppointmentDoctorById(int id);
    public List<Appointment> getListAppointmentPatientById(int id);

}
