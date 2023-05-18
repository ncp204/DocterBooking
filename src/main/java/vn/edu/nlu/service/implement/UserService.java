package vn.edu.nlu.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.edu.nlu.entity.BaseUser;
import vn.edu.nlu.entity.Doctor;
import vn.edu.nlu.entity.Patient;
import vn.edu.nlu.payload.respose.LoginResponse;
import vn.edu.nlu.repository.DoctorRepository;
import vn.edu.nlu.repository.PatientRepository;
import vn.edu.nlu.security.jwt.JwtTokenProvider;
import vn.edu.nlu.service.IUserService;

import java.util.Optional;

@Component
public class UserService implements IUserService {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public LoginResponse authLogin(String email, String password) {
        email = email.trim();
        password = password.trim();
        Optional<Doctor> doctor = doctorRepository.findDoctorByEmail(email);
        LoginResponse loginResponse;
        int id;
        String token;
        if (doctor.isPresent()) {
            Doctor dt = doctor.get();
            if (dt.getPassword().trim().equals(password)) {
                id = dt.getId();
                token = jwtTokenProvider.generateToken(dt.getEmail());
                loginResponse = LoginResponse.builder().id(id).token(token).roles("Doctor").userName(dt.getUser_name()).build();
                return loginResponse;
            }
        } else {
            Optional<Patient> patient = patientRepository.findPatientByEmail(email);
            if (patient.isPresent()) {
                Patient pt = patient.get();
                if (pt.getPassword().trim().equals(password)) {
                    id = pt.getId();
                    token = jwtTokenProvider.generateToken(pt.getEmail());
                    loginResponse = LoginResponse.builder().id(id).token(token).roles("Patient").userName(pt.getUser_name()).build();
                    return loginResponse;
                }
            }
        }
        return null;
    }
}