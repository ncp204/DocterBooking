package vn.edu.nlu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.nlu.dto.DoctorDetailDto;
import vn.edu.nlu.dto.Dtomapper;
import vn.edu.nlu.entity2.Doctor;
import vn.edu.nlu.exception.ServiceException;
import vn.edu.nlu.service2.IDoctorService;
import vn.edu.nlu.service2.implement.DoctorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    IDoctorService doctorService;

//    doctor list

    @GetMapping("/list")
    public List<Doctor> getDoctors() {
        return doctorService.getAllDoctor();
    }

    @GetMapping("/filter")
    public List<Doctor> filerDoctor(@RequestParam("gender") String gender,
                                    @RequestParam("degree") String degree, @RequestParam("specialize") String specialize) {
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
