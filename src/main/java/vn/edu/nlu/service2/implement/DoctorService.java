package vn.edu.nlu.service2.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import vn.edu.nlu.entity2.Doctor;
import vn.edu.nlu.exception.ServiceException;
import vn.edu.nlu.reposiroty2.DoctorRepository;
import vn.edu.nlu.service2.IDoctorService;

import java.util.List;

@Component
public class DoctorService implements IDoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public List<Doctor> getAllDoctor() {
        List<Doctor> doctors = doctorRepository.findAll();
        if (doctors != null) {
            return doctors;
        } else {
            throw new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR, "Không tìm thấy bác sĩ nào");
        }
    }
}
