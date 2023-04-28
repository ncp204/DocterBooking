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

    @Override
    public List<Doctor> filerDoctor(String gender, String degree, String specialize) {
        List<Doctor> doctors = null;
        if (gender != "" && degree != "" && specialize != "") {
            doctors = doctorRepository.findByGenderAndDegreeAndSpecialize(gender, degree, specialize);
        } else if (gender != "" && degree != "") {
            doctors = doctorRepository.findByGenderAndDegree(gender, degree);
        } else if (gender != "" && specialize != "") {
            doctors = doctorRepository.findByGenderAndSpecialize(gender, specialize);
        } else if (degree != "" && specialize != "") {
            doctors = doctorRepository.findByDegreeAndSpecialize(degree, specialize);
        } else if (gender != "") {
            doctors = doctorRepository.findByGender(gender);
        } else if (degree != "") {
            doctors = doctorRepository.findByDegree(degree);
        } else {
            doctors = doctorRepository.findBySpecialize(specialize);
        }
        if (doctors != null) {
            return doctors;
        } else {
            throw new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR, "Không tìm thấy bác sĩ nào");
        }
    }


}
