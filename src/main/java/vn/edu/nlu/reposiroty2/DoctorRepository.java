package vn.edu.nlu.reposiroty2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.nlu.entity2.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
