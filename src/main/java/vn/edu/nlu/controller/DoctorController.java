package vn.edu.nlu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.nlu.entity2.Doctor;
import vn.edu.nlu.service2.implement.DoctorService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @GetMapping("/doctor/list")
    public List<Doctor> getDoctors() {
        return doctorService.getAllDoctor();
    }

    @GetMapping("/doctor/filter")
    public List<Doctor> filerDoctor(@DefaultValue("nam")  @RequestParam("gender")  String gender,
                                    @DefaultValue("TS.BS") @RequestParam("degree") String degree, @DefaultValue("Tâm thần") @RequestParam("specialize") String specialize) {
        System.out.println(gender);
        System.out.println(degree);
        System.out.println(specialize);
        return doctorService.filerDoctor(gender,degree,specialize);
    }

    @GetMapping("/hau")
    public String hau(){
        return  "hau";
    }
}
