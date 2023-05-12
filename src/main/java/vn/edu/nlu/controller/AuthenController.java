package vn.edu.nlu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.nlu.entity.Patient;
import vn.edu.nlu.payload.request.SignupRequest;
import vn.edu.nlu.service.IPatientService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/authen")
public class AuthenController {
    @Autowired
    IPatientService patientService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest request, HttpServletRequest servletRequest){
        return new ResponseEntity<Patient>(patientService.signupPatient(request), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/verify/{token}")
    public String verifyToken(@PathVariable String token){
        if (patientService.checkToken(token)){
            return "your account has been active, \n Login now!!";
        }
        return "Your verification code has been used or incorrect !!";
    }

}
