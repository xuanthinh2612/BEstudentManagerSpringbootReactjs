package springReact.StudentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import springReact.StudentManagement.dto.SchoolClassDto;
import springReact.StudentManagement.service.SchoolClassService;

import java.util.List;

@RestController
@RequestMapping("/class")
@CrossOrigin("*")
public class ClassController {

    @Autowired
    SchoolClassService schoolClassService;

    @GetMapping("/findAll")
    public ResponseEntity<List<SchoolClassDto>> findAll() {
        List<SchoolClassDto> classListDto = schoolClassService.findAll();
        return new ResponseEntity<>(classListDto, HttpStatus.OK);
    }

    @Transactional
    @PostMapping(value = {"/create", "/update"})
    public ResponseEntity<SchoolClassDto> createNewClass(@RequestBody SchoolClassDto schoolClassDto) {
        SchoolClassDto savedClassDto = schoolClassService.save(schoolClassDto);
        return new ResponseEntity<>(savedClassDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteClass(@PathVariable("id") Long id) {
        schoolClassService.deleteClassById(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
