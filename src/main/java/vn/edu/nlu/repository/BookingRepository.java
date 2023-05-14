package vn.edu.nlu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.nlu.entity.Appointment;
import vn.edu.nlu.entity.Booking;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {
    public List<Booking> findByDoctor_id(int id);
    public List<Booking> findByPatient_id(int id);
}
