package vn.edu.nlu.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.edu.nlu.entity.Doctor;
import vn.edu.nlu.entity.Patient;
import vn.edu.nlu.repository.DoctorRepository;
import vn.edu.nlu.repository.PatientRepository;
import vn.edu.nlu.service.IUserService;

import java.util.Optional;

@Component
public class UserService implements IUserService {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;

    @Override
    public Boolean authLogin(String email, String password) {
        email = email.trim();
        password = password.trim();
        Optional<Doctor> doctor = doctorRepository.findDoctorByEmail(email);
        if(doctor.isPresent()) {
            return doctor.get().getPassword().equals(password);
        }else {
            Optional<Patient> patient = patientRepository.findPatientByEmail(email);
            if(patient.isPresent()) {
                return patient.get().getPassword().equals(password);
            }
        }
        return false;
    }
}
