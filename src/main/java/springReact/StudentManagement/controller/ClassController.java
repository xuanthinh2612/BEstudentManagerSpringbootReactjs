package springReact.StudentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/findAll")
    public ResponseEntity<List<SchoolClassDto>> findAll() {
        List<SchoolClassDto> classListDto = schoolClassService.findAll();
        return new ResponseEntity<>(classListDto, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/getClass/{id}")
    public ResponseEntity<SchoolClassDto> getClassById(@PathVariable("id") Long classId) {
        SchoolClassDto classDto = schoolClassService.findById(classId);
        return new ResponseEntity<>(classDto, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    @PostMapping(value = {"/create", "/update"})
    public ResponseEntity<SchoolClassDto> createNewClass(@RequestBody SchoolClassDto schoolClassDto) {
        SchoolClassDto savedClassDto = schoolClassService.save(schoolClassDto);
        return new ResponseEntity<>(savedClassDto, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteClass(@PathVariable("id") Long id) {
        schoolClassService.deleteClassById(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
