package vn.edu.nlu.service;

import org.springframework.stereotype.Service;

@Service

public interface IUserService {
    Boolean authLogin(String email, String password);
}
