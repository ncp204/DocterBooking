package vn.edu.nlu.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.edu.nlu.entity.BaseUser;
import vn.edu.nlu.entity.Doctor;
import vn.edu.nlu.entity.Patient;
import vn.edu.nlu.payload.respose.LoginResponse;
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
    public BaseUser authLogin(String email, String password) {
        email = email.trim();
        password = password.trim();
        Optional<Doctor> doctor = doctorRepository.findDoctorByEmail(email);
        if (doctor.isPresent()) {
            return doctor.get().getPassword().trim().equals(password) ? doctor.get() : null;
        } else {
            Optional<Patient> patient = patientRepository.findPatientByEmail(email);
            if (patient.isPresent()) {
                return patient.get().getPassword().trim().equals(password) ? patient.get() : null;
            }
        }
        return null;
    }
}
