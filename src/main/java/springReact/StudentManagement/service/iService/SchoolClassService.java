package springReact.StudentManagement.service.iService;

import springReact.StudentManagement.model.SchoolClass;

import java.util.List;

public interface SchoolClassService {
    SchoolClass save(SchoolClass schoolClass);
    List<SchoolClass> findAll();

    SchoolClass findById(Long id);
}
