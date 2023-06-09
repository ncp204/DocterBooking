package vn.edu.nlu.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.edu.nlu.entity.BaseUser;
import vn.edu.nlu.exception.ServiceException;
import vn.edu.nlu.payload.request.LoginForm;
import vn.edu.nlu.payload.respose.LoginResponse;
import vn.edu.nlu.security.jwt.JwtTokenProvider;
import vn.edu.nlu.service.implement.UserService;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class LoginController {
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @ResponseBody
    @PostMapping("auth/login")
    public LoginResponse handleLogin(@Valid @RequestBody LoginForm loginForm) {
        LoginResponse loginResponse = userService.authLogin(loginForm.getEmail(), loginForm.getPassword());
        if(loginResponse != null) {
            return loginResponse;
        } else {
            throw new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR, "Tài khoản hoặc mật khẩu không chính xác");
        }
    }
}
