package vn.edu.nlu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.nlu.entity.Patient;
import vn.edu.nlu.service.IPatientService;

import java.util.List;

@RestController("/patients")
@CrossOrigin(origins = "*")
public class PatientController {
    @Autowired
    IPatientService patientService;

    @GetMapping
    public List<Patient> patients(){
        try {
            return null;
        }catch (Exception e){
            return null;
        }
    }
}
