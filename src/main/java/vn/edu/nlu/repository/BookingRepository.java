package vn.edu.nlu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.nlu.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking,Integer> {
}
