package vn.edu.nlu.dto;

import vn.edu.nlu.entity.Appointment;
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

    public static AppointmentDto appointmentMap(Appointment appointment){
        return AppointmentDto.builder()
                .id(appointment.getId())
                .patientName(appointment.getPatientName())
                .patientGender(appointment.getPatientGender())
                .patientPhone(appointment.getPatientPhone())
                .patientEmail(appointment.getPatientEmail())
                .dateBooking(appointment.getDateBooking())
                .dateEnd(appointment.getDateEnd())
                .status(appointment.getStatus())
                .doctor_id(appointment.getDoctor().getId())
                .patient_id(appointment.getPatient().getId())
                .description(appointment.getDescription())
                .build();
    }
}
