package vn.edu.nlu.service2;

import org.springframework.stereotype.Service;
import vn.edu.nlu.entity2.Patient;
import vn.edu.nlu.payload.request.SignupRequest;

@Service
public interface IPatientService {
    Patient signupPatient(SignupRequest request);

    boolean checkToken(String token);
}
