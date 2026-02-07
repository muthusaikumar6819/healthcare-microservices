package com.sai.authservice.service;

import com.sai.authservice.dto.LoginRequest;
import com.sai.authservice.dto.RegisterRequest;
import com.sai.authservice.entity.User;
import com.sai.authservice.repository.UserRepository;
import com.sai.authservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String register(RegisterRequest request) {

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        userRepository.save(user);

        return "User registered successfully";
    }

    public String login(LoginRequest request) {

        User user = userRepository.findByUsername(request.getUsername())
                .orElse(null);

        if (user == null) {
            return "Invalid username or password";
        }

        boolean passwordMatches =
                passwordEncoder.matches(request.getPassword(), user.getPassword());

        if (!passwordMatches) {
            return "Invalid username or password";
        }

        return jwtService.generateToken(user.getUsername());
    }
}



