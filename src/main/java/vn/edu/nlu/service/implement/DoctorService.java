package vn.edu.nlu.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import vn.edu.nlu.dto.AppointmentDto;
import vn.edu.nlu.dto.DoctorDetailDto;
import vn.edu.nlu.dto.Dtomapper;
import vn.edu.nlu.entity.Appointment;
import vn.edu.nlu.repository.DoctorRepository;
import vn.edu.nlu.entity.Doctor;
import vn.edu.nlu.exception.ServiceException;
import vn.edu.nlu.service.IDoctorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DoctorService implements IDoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public List<DoctorDetailDto> getAllDoctor() {
        List<Doctor> doctors = doctorRepository.findAll();
        List<DoctorDetailDto> result = new ArrayList<>();
        for (Doctor d:doctors) {
            DoctorDetailDto doctorDetailDto = Dtomapper.doctorDetailMap(d);
            result.add(doctorDetailDto);
        }
        return result;
    }

    @Override
    public List<DoctorDetailDto> filerDoctor(String gender, String degree, String specialize) {
        List<Doctor> doctors = null;
        if(gender == "" && degree == "" && specialize == "") return  getAllDoctor();
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
            List<DoctorDetailDto> result = new ArrayList<>();
            for (Doctor d:doctors) {
                DoctorDetailDto doctorDetailDto = Dtomapper.doctorDetailMap(d);
                result.add(doctorDetailDto);
            }
            return result;
        } else {
            throw new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR, "Không tìm thấy bác sĩ nào");
        }
    }

    @Override
    public DoctorDetailDto getDetailById(int id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isEmpty()){
            return null;
        }
        DoctorDetailDto doctorDetailDto = Dtomapper.doctorDetailMap(doctor.get());
        return doctorDetailDto;
    }


}
