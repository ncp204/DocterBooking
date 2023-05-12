package vn.edu.nlu.service2;

import org.springframework.stereotype.Service;
import vn.edu.nlu.dto.DoctorDetailDto;
import vn.edu.nlu.entity2.Doctor;

import java.util.List;
import java.util.Optional;

@Service

public interface IDoctorService {
    List<Doctor> getAllDoctor();
    List<Doctor> filerDoctor(String gender, String degree, String specialize);

    DoctorDetailDto getDetailById(int id);
}
