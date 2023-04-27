package vn.edu.nlu.service2.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.edu.nlu.reposiroty2.PatientRepository;
import vn.edu.nlu.service2.IPatientService;

@Component
public class PatientService implements IPatientService {
    @Autowired
    PatientRepository patientRepository;
}
