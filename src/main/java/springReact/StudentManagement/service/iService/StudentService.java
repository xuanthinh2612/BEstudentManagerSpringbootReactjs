package springReact.StudentManagement.service.iService;

import springReact.StudentManagement.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAdd();
    Student save(Student student);

    Student findById(Long id);

    void deleteById(Long id);
}
