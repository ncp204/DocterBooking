package vn.edu.nlu.command;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vn.edu.nlu.entity.Role;
import vn.edu.nlu.entity.User;
import vn.edu.nlu.entity2.BaseUser;
import vn.edu.nlu.entity2.Degree;
import vn.edu.nlu.entity2.Doctor;
import vn.edu.nlu.entity2.Specialize;
import vn.edu.nlu.reposiroty2.DegreeRepository;
import vn.edu.nlu.reposiroty2.DoctorRepository;
import vn.edu.nlu.reposiroty2.SpecializeRepository;
import vn.edu.nlu.repository.RoleRepository;
import vn.edu.nlu.repository.UserRepository;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataLoader  implements CommandLineRunner {
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;
    // respository 2
    private final DoctorRepository doctorRepository;

    private final DegreeRepository degreeRepository;

    private final SpecializeRepository specializeRepository;

    @Override
    public void run(String... args) throws Exception {
        if(roleCheckExist()){
            createRole();
        }
        if(userCheckExist()){
            createUser();
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
    }
    public void createRole(){
        Role role_user = Role.builder().name("ROLE_USER").build();
        Role role_doctor = Role.builder().name("ROLE_DOCTOR").build();
        roleRepository.save(role_user);
        roleRepository.save(role_doctor);

    }
    public void createUser(){
        Set<Role> roles = new HashSet<>();

        roles.add(roleRepository.findById(1).get());
        User user = User.builder()
            .user_name("black jack")
                .phone("1234567890")
                .email("john.doe@example.com")
                .password("123123")
                .specialize("Java Developer")
                .active(true)
                .register_date(new Date(System.currentTimeMillis()))
                .roles(roles)
            . build();

        userRepository.save(user);
    }

    public void createDoctor(){
       Doctor doctor = new Doctor();
       doctor.setUser_name("doctor1");
       doctor.setPhone("0824831867");
       doctor.setEmail("nguyenhau@gmail.com");
       doctor.setPassword("123456");
       doctor.setFullName("nguyen van hau");
       doctor.setGender("Nam");
       doctor.setSpecialize("Tâm thần");
       doctor.setDegree("TS.BS");
       doctorRepository.save(doctor);

        Doctor doctor1 = new Doctor();
        doctor1.setUser_name("doctor2");
        doctor1.setPhone("0123456789");
        doctor1.setEmail("jalfdkjaslk@gmail.com");
        doctor1.setPassword("594488408");
        doctor1.setFullName("nguyen thi b");
        doctor1.setGender("Nữ");
        doctor1.setSpecialize("Tâm thần");
        doctor1.setDegree("GS.TS.BS");
        doctorRepository.save(doctor1);


    }

    public void createDegree(){
       degreeRepository.save(new Degree("TS.BS"));
        degreeRepository.save(new Degree("GS.TS.BS"));
        degreeRepository.save(new Degree("PSG.TS.BS"));



    }

    public void createSpecialze(){
        specializeRepository.save(new Specialize("Tâm thần"));
        specializeRepository.save(new Specialize("Nhi"));
        specializeRepository.save(new Specialize("Mắt"));
        specializeRepository.save(new Specialize("Dinh dưỡng"));


    }


    public boolean userCheckExist(){
        return userRepository.findAll().isEmpty();
    }
    public boolean roleCheckExist(){
        return userRepository.findAll().isEmpty();
    }

    public boolean doctorCheckExist(){
        return doctorRepository.findAll().isEmpty();
    }
    public boolean degreeCheckExist(){
        return degreeRepository.findAll().isEmpty();
    }
    public boolean specializeCheckExist(){
        return specializeRepository.findAll().isEmpty();
    }
}
