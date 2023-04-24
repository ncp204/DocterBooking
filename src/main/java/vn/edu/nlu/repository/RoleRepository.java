package vn.edu.nlu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.nlu.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
