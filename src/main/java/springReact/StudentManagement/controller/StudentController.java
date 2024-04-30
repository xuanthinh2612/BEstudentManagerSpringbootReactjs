package springReact.StudentManagement.controller;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import springReact.StudentManagement.model.Student;
import springReact.StudentManagement.service.iService.SchoolClassService;
import springReact.StudentManagement.service.iService.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    EntityManager entityManager;

    @Autowired
    SchoolClassService schoolClassService;

    @GetMapping("/list")
    public ResponseEntity<List<Student>> findAllStudent() {
        List<Student> resultList = studentService.findAdd();
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    @Transactional
    @PostMapping(value = {"/create", "/update"})
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {

        try {
            Student savedStudent = studentService.save(student);
            return new ResponseEntity<>(savedStudent, HttpStatus.OK);
        } catch (Exception e) {
            // Handle any exceptions appropriately, such as logging or returning an error response
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getStudent/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.findById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteStudentById(@PathVariable Long id) {
        studentService.deleteById(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
