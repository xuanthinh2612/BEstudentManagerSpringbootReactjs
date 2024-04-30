package springReact.StudentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springReact.StudentManagement.model.SchoolClass;
import springReact.StudentManagement.service.iService.SchoolClassService;

import java.util.List;

@RestController
@RequestMapping("/class")
@CrossOrigin("*")
public class ClassController {

    @Autowired
    SchoolClassService schoolClassService;

    @GetMapping("/findAll")
    public ResponseEntity<List<SchoolClass>> findAll() {
        List<SchoolClass> classList = schoolClassService.findAll();
        return new ResponseEntity<>(classList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<SchoolClass> createNewClass(@RequestBody SchoolClass schoolClass) {
        SchoolClass savedClass = schoolClassService.save(schoolClass);
        return new ResponseEntity<>(savedClass, HttpStatus.OK);
    }


}
