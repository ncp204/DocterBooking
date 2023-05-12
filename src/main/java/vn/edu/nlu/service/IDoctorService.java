package vn.edu.nlu.service;

import org.springframework.stereotype.Service;
import vn.edu.nlu.dto.DoctorDetailDto;
import vn.edu.nlu.entity.Doctor;

import java.util.List;

@Service

public interface IDoctorService {
    List<Doctor> getAllDoctor();
    List<Doctor> filerDoctor(String gender, String degree, String specialize);

    DoctorDetailDto getDetailById(int id);
}
