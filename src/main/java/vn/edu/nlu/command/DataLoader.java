package vn.edu.nlu.command;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vn.edu.nlu.entity.*;
import vn.edu.nlu.repository.*;

import java.util.ArrayList;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class DataLoader  implements CommandLineRunner {
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    private final DegreeRepository degreeRepository;

    private final SpecializeRepository specializeRepository;
    private final AppointmentRepository appointmentRepository;

    @Override
    public void run(String... args) throws Exception {
//        if(roleCheckExist()){
//            createRole();
//        }
        if(patientCheckExist()){
            createPatient();
        }
        if(doctorCheckExist()){
            createDoctor();
        }
        if(degreeCheckExist()){
            createDegree();
        }
        if(specializeCheckExist()){
            createSpecialze();
        }
        if (appointmentCheckExist()){
            createAppointment();
        }
    }
//    public void createRole(){
//        Role role_user = Role.builder().name("ROLE_USER").build();
//        Role role_doctor = Role.builder().name("ROLE_DOCTOR").build();
//        roleRepository.save(role_user);
//        roleRepository.save(role_doctor);
//
//    }
    public void createPatient(){
        Patient patient1 = Patient.builder()
                .user_name("black jack")
                .phone("1234567890")
                .email("john.doe@example.com")
                .password("123123")
                .active(true)
                .gender("Nam")
                .appointments(new ArrayList<>())
                .active(true)
                .token("")
                .build();
        patientRepository.save(patient1);

        Patient patient2 = Patient.builder()
                .user_name("jane doe")
                .phone("0987654321")
                .email("jane.doe@example.com")
                .password("password123")
                .active(true)
                .gender("nu")
                .appointments(new ArrayList<>())
                .active(true)
                .token("")
                .build();
        patientRepository.save(patient2);

        Patient patient3 = Patient.builder()
                .user_name("will smith")
                .phone("5551234567")
                .email("will.smith@example.com")
                .password("welcome123")
                .active(true)
                .gender("nam")
                .appointments(new ArrayList<>())
                .active(true)
                .token("")
                .build();
        patientRepository.save(patient3);

        Patient patient4 = Patient.builder()
                .user_name("mary jones")
                .phone("1235557890")
                .email("mary.jones@example.com")
                .password("secret123")
                .active(true)
                .gender("nu")
                .appointments(new ArrayList<>())
                .active(true)
                .token("")
                .build();
        patientRepository.save(patient4);

        Patient patient5 = Patient.builder()
                .user_name("jimmy carter")
                .phone("7891234560")
                .email("jimmy.carter@example.com")
                .password("password987")
                .active(true)
                .gender("nam")
                .appointments(new ArrayList<>())
                .active(true)
                .token("")
                .build();
        patientRepository.save(patient5);
    }

    public void createDoctor(){
       Doctor doctor = new Doctor();
       doctor.setUser_name("doctor1");
       doctor.setPhone("0824831867");
       doctor.setEmail("nguyenhau@gmail.com");
       doctor.setPassword("123456");
       doctor.setFullName("Nguyễn Văn Hậu");
       doctor.setGender("Nam");
       doctor.setSpecialize("Tâm thần");
       doctor.setDegree("TS.BS");
       doctor.setAppointments(new ArrayList<>());
       doctorRepository.save(doctor);

        Doctor doctor1 = new Doctor();
        doctor1.setUser_name("doctor2");
        doctor1.setPhone("0123456789");
        doctor1.setEmail("jalfdkjaslk@gmail.com");
        doctor1.setPassword("594488408");
        doctor1.setFullName("Nguyễn Thị Bê");
        doctor1.setGender("Nữ");
        doctor1.setSpecialize("Tâm thần");
        doctor1.setDegree("GS.TS.BS");
        doctor1.setAppointments(new ArrayList<>());
        doctorRepository.save(doctor1);

        Doctor doctor2 = new Doctor();
        doctor2.setUser_name("doctor3");
        doctor2.setPhone("0987654321");
        doctor2.setEmail("doctor3@gmail.com");
        doctor2.setPassword("329565369");
        doctor2.setFullName("Trần Văn Đoàn");
        doctor2.setGender("nam");
        doctor2.setSpecialize("Dinh dưỡng");
        doctor2.setDegree("Bác Sĩ");
        doctor2.setAppointments(new ArrayList<>());
        doctorRepository.save(doctor2);


        Doctor doctor3 = new Doctor();
        doctor3.setUser_name("doctor4");
        doctor3.setPhone("0938278465");
        doctor3.setEmail("doctor4@gmail.com");
        doctor3.setPassword("381029384");
        doctor3.setFullName("Lê Quang Trung");
        doctor3.setGender("nam");
        doctor3.setSpecialize("Dinh dưỡng");
        doctor3.setDegree("THS.BS");
        doctor3.setAppointments(new ArrayList<>());
        doctorRepository.save(doctor3);

        Doctor doctor4 = new Doctor();
        doctor4.setUser_name("doctor5");
        doctor4.setPhone("0987523968");
        doctor4.setEmail("doctor5@gmail.com");
        doctor4.setPassword("838392003");
        doctor4.setFullName("Phạm Thu Hương");
        doctor4.setGender("nữ");
        doctor4.setSpecialize("Mắt");
        doctor4.setDegree("TS.BS");
        doctor4.setAppointments(new ArrayList<>());
        doctorRepository.save(doctor4);

        Doctor doctor5 = new Doctor();
        doctor5.setUser_name("doctor6");
        doctor5.setPhone("0903127384");
        doctor5.setEmail("doctor6@gmail.com");
        doctor5.setPassword("394781291");
        doctor5.setFullName("Nguyễn Văn Hải");
        doctor5.setGender("nam");
        doctor5.setSpecialize("Tai - Mũi - Họng");
        doctor5.setDegree("GS.TS.BS");
        doctor5.setAppointments(new ArrayList<>());
        doctorRepository.save(doctor5);

        Doctor doctor6 = new Doctor();
        doctor6.setUser_name("doctor7");
        doctor6.setPhone("0918273645");
        doctor6.setEmail("doctor7@gmail.com");
        doctor6.setPassword("374819202");
        doctor6.setFullName("Trần Thị Mai");
        doctor6.setGender("nữ");
        doctor6.setSpecialize("Nhi");
        doctor6.setDegree("Chuyên Gia Tâm Lý");
        doctor6.setAppointments(new ArrayList<>());
        doctorRepository.save(doctor6);
    }

    public void createDegree(){
        degreeRepository.save(new Degree("Chuyên Gia Tâm Lý"));
        degreeRepository.save(new Degree("Bác Sĩ"));
       degreeRepository.save(new Degree("TS.BS"));
       degreeRepository.save(new Degree("GS.TS.BS"));
       degreeRepository.save(new Degree("PSG.TS.BS"));
    }

    public void createSpecialze(){
        specializeRepository.save(new Specialize("Tai - Mũi - Họng"));
        specializeRepository.save(new Specialize("Tâm thần"));
        specializeRepository.save(new Specialize("Nhi"));
        specializeRepository.save(new Specialize("Mắt"));
        specializeRepository.save(new Specialize("Dinh dưỡng"));

    }

    public void createAppointment(){
        Patient patient = patientRepository.findById(1).get();
        Patient patient1 = patientRepository.findById(2).get();
        Doctor doctor1 = doctorRepository.findById(1).get();
        Doctor doctor2 = doctorRepository.findById(4).get();
        Doctor doctor3 = doctorRepository.findById(3).get();

        Appointment appointment1 = Appointment.builder()
                .patient(patient)
                .patientName("Phạm Sĩ Thuận")
                .patientEmail("thuan@gmail.com")
                .patientGender("Nam")
                .patientPhone("9386498362")
                .doctor(doctor3)
                .description("đau bụng khó tiêu")
                .dateBooking(new Date(2023,5,12,15,40))
                .dateEnd(new Date(2023,5,12,16,40))
                .status("đã khám")
                .build();
         appointmentRepository.save(appointment1);

        Appointment appointment2 = Appointment.builder()
                .patient(patient)
                .patientName("Lê Thị Trang")
                .patientEmail("trang_le@gmail.com")
                .patientGender("nữ")
                .patientPhone("9012345678")
                .doctor(doctor1)
                .description("đau đầu và mệt mỏi")
                .dateBooking(new Date(2024,6,15,9,30))
                .dateEnd(new Date(2024,6,15,10,30))
                .status("đã khám")
                .build();
        appointmentRepository.save(appointment2);

        Appointment appointment3 = Appointment.builder()
                .patient(patient1)
                .patientName(patient1.getUser_name())
                .patientEmail(patient1.getEmail())
                .patientGender(patient1.getGender())
                .patientPhone(patient1.getPhone())
                .doctor(doctor3)
                .description("ho và sổ mũi")
                .dateBooking(new Date(2023,8,1,18,30))
                .dateEnd(new Date(2023,8,1,19,30))
                .status("đã khám")
                .build();
        appointmentRepository.save(appointment3);

        Appointment appointment4 = Appointment.builder()
                .patient(patient1)
                .patientName("Trần Thuỳ Linh")
                .patientEmail("linh_tran@gmail.com")
                .patientGender("nữ")
                .patientPhone("9451287436")
                .doctor(doctor1)
                .description("đau đầu và nhiều gò má")
                .dateBooking(new Date(2022,11,10,11,0))
                .dateEnd(new Date(2022,11,10,12,0))
                .status("đã khám")
                .build();
        appointmentRepository.save(appointment4);
    }

    public boolean patientCheckExist(){
        return patientRepository.findAll().isEmpty();
    }
//    public boolean roleCheckExist(){
//        return userRepository.findAll().isEmpty();
//    }

    public boolean doctorCheckExist(){
        return doctorRepository.findAll().isEmpty();
    }
    public boolean degreeCheckExist(){
        return degreeRepository.findAll().isEmpty();
    }
    public boolean specializeCheckExist(){
        return specializeRepository.findAll().isEmpty();
    }
    public boolean appointmentCheckExist(){
        return appointmentRepository.findAll().isEmpty();
    }
}
