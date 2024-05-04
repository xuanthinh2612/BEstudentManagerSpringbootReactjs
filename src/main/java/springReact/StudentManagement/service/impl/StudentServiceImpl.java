package springReact.StudentManagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springReact.StudentManagement.dto.StudentDto;
import springReact.StudentManagement.exception.ResourceNotFoundException;
import springReact.StudentManagement.mapper.StudentMapper;
import springReact.StudentManagement.model.SchoolClass;
import springReact.StudentManagement.model.Student;
import springReact.StudentManagement.repository.SchoolClassRepository;
import springReact.StudentManagement.repository.StudentRepository;
import springReact.StudentManagement.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    private SchoolClassRepository schoolClassRepository;

    @Override
    public List<StudentDto> findAdd() {
        List<Student> studentList = studentRepository.findAll();
        return studentList.stream().map(StudentMapper::mapToStudentDto).toList();
    }

    @Override
    public StudentDto save(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        // If the student has a SchoolClass associated and it has an ID,
        // ensure it's managed by fetching it from the database
        if (studentDto.getSchoolClass() != null && studentDto.getSchoolClass().getId() != null) {
            SchoolClass existingSchoolClass = schoolClassRepository.findById(studentDto.getSchoolClass().getId()).orElseThrow(
                    () -> new ResourceNotFoundException("Class is not exists with id: " + studentDto.getSchoolClass().getId())
            );
            student.setSchoolClass(existingSchoolClass);
        } else {
            // If no SchoolClass is associated with the student, set it to null
            student.setSchoolClass(null);
        }

        // Save the student entity
        Student saveStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(saveStudent);
    }

    @Override
    public StudentDto findById(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student is not exists with id: " + studentId));
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }


}
