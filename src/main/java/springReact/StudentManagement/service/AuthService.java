package springReact.StudentManagement.service;

import springReact.StudentManagement.dto.LoginDto;
import springReact.StudentManagement.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);

    String login(LoginDto loginDto);
}
