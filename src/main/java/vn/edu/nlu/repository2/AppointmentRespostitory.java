package vn.edu.nlu.repository2;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.nlu.entity2.Appointment;

import java.util.List;

public interface AppointmentRespostitory extends JpaRepository<Appointment,Integer> {
    public List<Appointment> findByDoctor_id(int id);
    public List<Appointment> findByPatient_id(int id);
}
