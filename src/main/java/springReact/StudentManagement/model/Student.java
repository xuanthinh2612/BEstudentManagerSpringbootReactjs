package springReact.StudentManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private  String firstName;
    @Column
    private  String lastName;
    @Column
    private  Integer age;
    @Column
    private  String address;
    @Column
    private  String email;

    @JoinColumn(name="school_class_id", referencedColumnName="id")
    @ManyToOne
    private  SchoolClass schoolClass;
}
