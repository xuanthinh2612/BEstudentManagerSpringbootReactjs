package springReact.StudentManagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springReact.StudentManagement.dto.SchoolClassDto;
import springReact.StudentManagement.exception.ResourceNotFoundException;
import springReact.StudentManagement.mapper.SchoolClassMapper;
import springReact.StudentManagement.model.SchoolClass;
import springReact.StudentManagement.repository.SchoolClassRepository;
import springReact.StudentManagement.service.SchoolClassService;

import java.util.List;

@Service
public class SchoolClassServiceImpl implements SchoolClassService {

    @Autowired
    SchoolClassRepository schoolClassRepository;

    @Override
    public SchoolClassDto save(SchoolClassDto schoolClassDto) {
        SchoolClass schoolClass = SchoolClassMapper.mapToSchoolClass(schoolClassDto);
        SchoolClass saveSchoolClass = schoolClassRepository.save(schoolClass);
        return SchoolClassMapper.mapToSchoolClassDto(saveSchoolClass);
    }

    @Override
    public List<SchoolClassDto> findAll() {
        List<SchoolClass> schoolClassList = schoolClassRepository.findAll();
        return schoolClassList.stream().map((SchoolClassMapper::mapToSchoolClassDto)).toList();
    }

    @Override
    public SchoolClassDto findById(Long schoolClassId) {
        SchoolClass schoolClass = schoolClassRepository.findById(schoolClassId).orElseThrow(
                () -> new ResourceNotFoundException("Department is not exists with a given id: " + schoolClassId)
        );

        return SchoolClassMapper.mapToSchoolClassDto(schoolClass);
    }

    @Override
    public void deleteClassById(Long schoolClassId) {
        schoolClassRepository.deleteById(schoolClassId);
    }

}
