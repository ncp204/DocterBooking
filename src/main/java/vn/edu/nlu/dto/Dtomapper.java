package vn.edu.nlu.dto;

import vn.edu.nlu.entity2.Doctor;

public class Dtomapper {
    public static DoctorDetailDto doctorDetailMap(Doctor doctor){
        return DoctorDetailDto.builder()
                .user_name(doctor.getUser_name())
                .email(doctor.getEmail())
                .phone(doctor.getPhone())
                .specialize(doctor.getSpecialize())
                .degree(doctor.getDegree())
                .build();
    }
}
