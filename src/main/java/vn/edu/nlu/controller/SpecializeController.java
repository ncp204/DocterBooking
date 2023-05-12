package vn.edu.nlu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.nlu.entity2.Degree;
import vn.edu.nlu.entity2.Specialize;
import vn.edu.nlu.repository2.SpecializeRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/specialize")
public class SpecializeController {

    @Autowired
    SpecializeRepository specializeRepository;
    @GetMapping("/all")
    public List<Specialize> getAllDegree(){
        return specializeRepository.findAll();
    }
}
