package vn.edu.nlu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.nlu.repository.UserRepository;

@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    UserRepository userRepository;

}
