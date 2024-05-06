package springReact.StudentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springReact.StudentManagement.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
    Optional<User> findByUsernameOrEmail(String username, String email);
}
