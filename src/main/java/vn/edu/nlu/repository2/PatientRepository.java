package vn.edu.nlu.repository2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.nlu.entity2.Patient;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {

    Optional<Patient> findByToken(String token);
}