package vn.edu.nlu.dto;

import vn.edu.nlu.entity.Doctor;

public class Dtomapper {
    public static DoctorDetailDto doctorDetailMap(Doctor doctor){
        return DoctorDetailDto.builder()
                .id(doctor.getId())
                .fullName(doctor.getFullName())
                .gender(doctor.getGender())
                .email(doctor.getEmail())
                .phone(doctor.getPhone())
                .specialize(doctor.getSpecialize())
                .degree(doctor.getDegree())
                .build();
    }
}
