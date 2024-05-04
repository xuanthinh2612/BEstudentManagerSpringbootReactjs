package springReact.StudentManagement.mapper;

import springReact.StudentManagement.dto.StudentDto;
import springReact.StudentManagement.model.Student;

public class StudentMapper {
    public static StudentDto mapToStudentDto(Student student) {
        return new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getAge(),
                student.getAddress(),
                student.getEmail(),
                student.getSchoolClass()
        );
    }

    public static Student mapToStudent(StudentDto studentDto) {
        return new Student
                (
                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getAge(),
                studentDto.getAddress(),
                studentDto.getEmail(),
                studentDto.getSchoolClass()
        );
    }
}
