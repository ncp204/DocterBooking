package vn.edu.nlu.service2.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.edu.nlu.reposiroty2.DoctorRepository;
import vn.edu.nlu.service2.IDoctorService;

@Component
public class DoctorService implements IDoctorService {
    @Autowired
    DoctorRepository doctorRepository;
}
