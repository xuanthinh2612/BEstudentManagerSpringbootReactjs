package springReact.StudentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springReact.StudentManagement.model.SchoolClass;
import springReact.StudentManagement.repository.SchoolClassRepository;
import springReact.StudentManagement.service.iService.SchoolClassService;

import java.util.List;

@Service
public class SchoolClassServiceImpl implements SchoolClassService {

    @Autowired
    SchoolClassRepository schoolClassRepository;

    @Override
    public SchoolClass save(SchoolClass schoolClass) {
        return schoolClassRepository.save(schoolClass);
    }

    @Override
    public List<SchoolClass> findAll() {
        return schoolClassRepository.findAll();
    }

    @Override
    public SchoolClass findById(Long id) {
        return schoolClassRepository.findById(id).orElse(null);
    }
}
