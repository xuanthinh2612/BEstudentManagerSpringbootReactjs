package springReact.StudentManagement.service;

import springReact.StudentManagement.dto.SchoolClassDto;
import springReact.StudentManagement.model.SchoolClass;

import java.util.List;

public interface SchoolClassService {
    SchoolClassDto save(SchoolClassDto schoolClassDto);

    List<SchoolClassDto> findAll();

    SchoolClassDto findById(Long id);

    void deleteClassById(Long id);
}
