package vn.edu.nlu.service2.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.edu.nlu.entity2.Patient;
import vn.edu.nlu.payload.request.SignupRequest;
import vn.edu.nlu.repository2.PatientRepository;
import vn.edu.nlu.service2.IPatientService;

import java.util.Optional;
import java.util.UUID;

@Component
public class PatientService implements IPatientService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    SendmailService sendmailService;

    @Override
    public Patient signupPatient(SignupRequest request) {
        String token = String.valueOf(UUID.randomUUID());
        Patient patient = Patient.builder()
                .user_name(request.getUserName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(request.getPassword())
                .active(false)
                .token(token)
                .build();

        sendmailService.sendVerificationEmail(patient, "http://localhost:8081/authen/verify/"+token);
        patientRepository.save(patient);
        return patient;
    }

    @Override
    public boolean checkToken(String token) {
        Optional<Patient> optional = patientRepository.findByToken(token);
        if (optional.isEmpty()){
            return false;
        }
        Patient patient = optional.get();
        patient.setToken(null);
        patient.setActive(true);
        patientRepository.save(patient);
        return true;
    }


}
