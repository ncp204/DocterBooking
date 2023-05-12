package vn.edu.nlu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.nlu.entity.Degree;
import vn.edu.nlu.repository.DegreeRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/degree")
public class DegreeController {
    @Autowired
    DegreeRepository degreeRepository;
    @GetMapping("/all")
    public List<Degree> getAllDegree(){
        return degreeRepository.findAll();
    }

}
