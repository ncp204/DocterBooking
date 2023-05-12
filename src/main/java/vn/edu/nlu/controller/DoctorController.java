package vn.edu.nlu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.nlu.dto.DoctorDetailDto;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.nlu.entity.Doctor;
import vn.edu.nlu.exception.ServiceException;
import vn.edu.nlu.service.IDoctorService;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@CrossOrigin(origins = "*")
public class DoctorController {
    @Autowired
    IDoctorService doctorService;

//    doctor list

    @GetMapping("/list")
    public List<Doctor> getDoctors() {
        return doctorService.getAllDoctor();
    }

    @GetMapping("/filter")
    public List<Doctor> filerDoctor(@DefaultValue("nam")  @RequestParam("gender")  String gender,
                                    @DefaultValue("TS.BS") @RequestParam("degree") String degree, @DefaultValue("Tâm thần") @RequestParam("specialize") String specialize) {
        System.out.println(gender);
        System.out.println(degree);
        System.out.println(specialize);
        return doctorService.filerDoctor(gender,degree,specialize);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDetailDoctor(@PathVariable int id){
        DoctorDetailDto doctorDetailDto = doctorService.getDetailById(id);
        if (doctorDetailDto == null){
            throw new ServiceException(HttpStatus.NO_CONTENT, "Không tìm thấy bác sĩ !!");
        }
        return new ResponseEntity<>(doctorDetailDto, HttpStatus.OK);
    }

    @GetMapping("/hau")
    public String hau(){
        return  "hau";
    }
}
