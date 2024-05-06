package springReact.StudentManagement.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springReact.StudentManagement.dto.LoginDto;
import springReact.StudentManagement.dto.RegisterDto;
import springReact.StudentManagement.exception.AppAPIException;
import springReact.StudentManagement.model.Role;
import springReact.StudentManagement.model.User;
import springReact.StudentManagement.repository.RoleRepository;
import springReact.StudentManagement.repository.UserRepository;
import springReact.StudentManagement.service.AuthService;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private AuthenticationManager authenticationManager;

    @Override
    public String register(RegisterDto registerDto) {

        // check username is already exists in database
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            throw new AppAPIException(HttpStatus.BAD_REQUEST, "Username already exists!");
        }

        // check email is already exists in database
        if (userRepository.existsByEmail(registerDto.getEmail())) {
            throw new AppAPIException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
        }

        User user = new User();

        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.findByName("ROLE_USER");

        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);

        return "User Registered Successfully!.";
    }

    @Override
    public String login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(),
                loginDto.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "User logged-in successfully!.";
    }
}
