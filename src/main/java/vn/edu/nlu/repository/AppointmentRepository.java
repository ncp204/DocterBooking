package vn.edu.nlu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.nlu.entity.Appointment;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    List<Appointment> findByDoctor_id(int id);

    List<Appointment> findByPatient_id(int id);

    @Query("SELECT a FROM Appointment a " +
            "WHERE a.doctor.id = :doctorId " +
            "AND FUNCTION('YEAR', a.dateBooking) = :year " +
            "AND FUNCTION('MONTH', a.dateBooking) = :month " +
            "AND FUNCTION('DAY', a.dateBooking) = :day")
    List<Appointment> findByDoctorIdAndDate(int doctorId, int year, int month, int day);
}
