package springReact.StudentManagement.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springReact.StudentManagement.model.SchoolClass;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String address;
    private String email;
    private SchoolClass schoolClass;
}
