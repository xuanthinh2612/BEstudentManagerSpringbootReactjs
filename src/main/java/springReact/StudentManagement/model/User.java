package springReact.StudentManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = true)
    private String password;

    //  fetch = FetchType.EAGER: Thuộc tính này xác định cách mà dữ liệu của thực thể liên quan sẽ được truy xuất từ cơ sở dữ liệu
    //  khi thực thể chính được truy vấn. Trong trường hợp FetchType.EAGER, dữ liệu liên quan sẽ được truy xuất ngay lập tức
    //  cùng với thực thể chính, điều này có nghĩa là Hibernate (hoặc ORM khác) sẽ thực hiện một câu truy vấn kết hợp
    //  để lấy dữ liệu của cả hai thực thể.
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;
}
