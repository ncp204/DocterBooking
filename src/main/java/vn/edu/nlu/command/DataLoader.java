package vn.edu.nlu.command;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vn.edu.nlu.entity.Role;
import vn.edu.nlu.entity.User;
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

    @Override
    public void run(String... args) throws Exception {
        if(roleCheckExist()){
            createRole();
        }
        if(userCheckExist()){
//            createUser();
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

        roles.add(role_doctor);
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
    public boolean userCheckExist(){
        return userRepository.findAll().isEmpty();
    }
    public boolean roleCheckExist(){
        return userRepository.findAll().isEmpty();
    }
}
