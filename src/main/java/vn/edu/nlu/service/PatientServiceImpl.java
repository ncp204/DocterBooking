package vn.edu.nlu.service;

import org.springframework.beans.factory.annotation.Autowired;
import vn.edu.nlu.repository.UserRepository;

public class PatientServiceImpl implements PatientService{
    @Autowired
    UserRepository userRepository;
}
