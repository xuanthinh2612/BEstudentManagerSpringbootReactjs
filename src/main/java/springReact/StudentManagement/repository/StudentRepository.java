package springReact.StudentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springReact.StudentManagement.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
