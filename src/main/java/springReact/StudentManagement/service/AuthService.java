package springReact.StudentManagement.service;

import springReact.StudentManagement.dto.JwtAuthResponse;
import springReact.StudentManagement.dto.LoginDto;
import springReact.StudentManagement.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);

    JwtAuthResponse login(LoginDto loginDto);
    JwtAuthResponse loginOrCreateBySNS(LoginDto loginDto);

}
