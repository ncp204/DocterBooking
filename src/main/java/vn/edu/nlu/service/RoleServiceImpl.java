package vn.edu.nlu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.edu.nlu.repository.RoleRepository;

@Component
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleRepository roleRepository;
}
