package springReact.StudentManagement.mapper;


import springReact.StudentManagement.dto.SchoolClassDto;
import springReact.StudentManagement.model.SchoolClass;

public class SchoolClassMapper {
    public static SchoolClassDto mapToSchoolClassDto(SchoolClass schoolClass) {
        return new SchoolClassDto(
                schoolClass.getId(),
                schoolClass.getName(),
                schoolClass.getDescription()
        );
    }

    public static SchoolClass mapToSchoolClass(SchoolClassDto schoolClassDto) {
        return new SchoolClass
                (
                        schoolClassDto.getId(),
                        schoolClassDto.getName(),
                        schoolClassDto.getDescription()
                );
    }
}
