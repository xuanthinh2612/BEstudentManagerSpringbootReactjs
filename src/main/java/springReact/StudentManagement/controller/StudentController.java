package springReact.StudentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import springReact.StudentManagement.dto.StudentDto;
import springReact.StudentManagement.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/list")
    public ResponseEntity<List<StudentDto>> findAllStudent() {
        List<StudentDto> resultList = studentService.findAdd();
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    @PostMapping(value = {"/create", "/update"})
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {

        try {
            StudentDto savedStudent = studentService.save(studentDto);
            return new ResponseEntity<>(savedStudent, HttpStatus.OK);
        } catch (Exception e) {
            // Handle any exceptions appropriately, such as logging or returning an error response
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/getStudent/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long studentId) {
        StudentDto studentDto = studentService.findById(studentId);
        return new ResponseEntity<>(studentDto, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteStudentById(@PathVariable Long id) {
        studentService.deleteById(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
