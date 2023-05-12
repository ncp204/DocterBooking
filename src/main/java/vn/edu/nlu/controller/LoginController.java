package vn.edu.nlu.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.edu.nlu.exception.ServiceException;
import vn.edu.nlu.payload.request.LoginForm;
import vn.edu.nlu.security.jwt.JwtTokenProvider;
import vn.edu.nlu.service2.implement.UserService;

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
    public String handleLogin(@Valid @RequestBody LoginForm loginForm) {
        boolean result = userService.authLogin(loginForm.getEmail(), loginForm.getPassword());
        if(result) {
            return jwtTokenProvider.generateToken(loginForm.getEmail());
        } else {
            throw new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR, "Tài khoản hoặc mật khẩu không chính xác");
        }
    }
}
