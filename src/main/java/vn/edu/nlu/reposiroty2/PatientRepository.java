package vn.edu.nlu.reposiroty2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.nlu.entity2.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
