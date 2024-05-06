package springReact.StudentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springReact.StudentManagement.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
