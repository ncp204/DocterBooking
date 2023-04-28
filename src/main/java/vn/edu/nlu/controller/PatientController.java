package vn.edu.nlu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.nlu.entity.User;
import vn.edu.nlu.service.PatientService;
import vn.edu.nlu.service.PatientServiceImpl;

import java.util.List;

@RestController("/patients")
@CrossOrigin(origins = "*")
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping
    public List<User> patients(){
        try {
            return null;
        }catch (Exception e){
            return null;
        }
    }
}
