package vn.edu.nlu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.edu.nlu.repository.UserRepository;

@Component
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    UserRepository userRepository;
}
