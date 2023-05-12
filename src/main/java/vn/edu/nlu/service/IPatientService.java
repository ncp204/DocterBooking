package vn.edu.nlu.service;

import org.springframework.stereotype.Service;
import vn.edu.nlu.entity.Patient;
import vn.edu.nlu.payload.request.SignupRequest;

@Service
public interface IPatientService {
    Patient signupPatient(SignupRequest request);

    boolean checkToken(String token);
}
