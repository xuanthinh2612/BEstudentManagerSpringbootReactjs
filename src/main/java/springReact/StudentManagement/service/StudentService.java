package springReact.StudentManagement.service;

import springReact.StudentManagement.dto.StudentDto;
import springReact.StudentManagement.model.Student;

import java.util.List;

public interface StudentService {

    List<StudentDto> findAdd();

    StudentDto save(StudentDto studentDto);

    StudentDto findById(Long id);

    void deleteById(Long id);
}
