package springReact.StudentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springReact.StudentManagement.model.SchoolClass;
import springReact.StudentManagement.model.Student;
import springReact.StudentManagement.repository.StudentRepository;
import springReact.StudentManagement.service.iService.SchoolClassService;
import springReact.StudentManagement.service.iService.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    private SchoolClassService schoolClassService;

    @Override
    public List<Student> findAdd() {
        return studentRepository.findAll();
    }

    @Override
    public Student save(Student student) {
        // If the student has a SchoolClass associated and it has an ID,
        // ensure it's managed by fetching it from the database
        if (student.getSchoolClass() != null && student.getSchoolClass().getId() != null) {
            SchoolClass existingSchoolClass = schoolClassService.findById(student.getSchoolClass().getId());
            student.setSchoolClass(existingSchoolClass);
        } else {
            // If no SchoolClass is associated with the student, set it to null
            student.setSchoolClass(null);
        }

        // Save the student entity
        return studentRepository.save(student);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }


}
