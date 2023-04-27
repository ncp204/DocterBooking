package vn.edu.nlu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.nlu.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {
}
