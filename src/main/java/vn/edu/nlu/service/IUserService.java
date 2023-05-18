package vn.edu.nlu.service;

import org.springframework.stereotype.Service;
import vn.edu.nlu.entity.BaseUser;
import vn.edu.nlu.payload.respose.LoginResponse;

@Service

public interface IUserService {
    LoginResponse authLogin(String email, String password);
}
