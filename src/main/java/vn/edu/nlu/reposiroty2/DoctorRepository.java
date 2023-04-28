package vn.edu.nlu.reposiroty2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.nlu.entity2.Doctor;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    List<Doctor> findByGenderAndDegreeAndSpecialize(String gender, String degree, String specialize);
    List<Doctor> findByGenderAndDegree(String gender, String degree);
    List<Doctor> findByGenderAndSpecialize(String gender, String specialize);
    List<Doctor> findByDegreeAndSpecialize(String degree, String specialize);

    List<Doctor> findByDegree(String degree);
    List<Doctor> findBySpecialize(String specialize);
    List<Doctor> findByGender(String gender);

    Optional<Doctor> findDoctorByEmail(String email);

}
