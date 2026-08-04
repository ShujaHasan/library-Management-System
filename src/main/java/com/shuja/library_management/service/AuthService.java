package com.shuja.library_management.service;

import com.shuja.library_management.dto.LoginRequestDTO;
import com.shuja.library_management.dto.LoginResponseDTO;
import com.shuja.library_management.dto.RegisterRequestDTO;
import com.shuja.library_management.dto.UserResponseDTO;
import com.shuja.library_management.exception.UsernameAlreadyExistsException;
import com.shuja.library_management.model.User;
import com.shuja.library_management.model.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import security.JwtService;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public UserResponseDTO convertTODTO(User user){
        return new UserResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getRole()
        );
    }

    public UserResponseDTO register(RegisterRequestDTO dto){

        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new UsernameAlreadyExistsException("Username already exists.");
        }

        String encodedPassword = passwordEncoder.encode(dto.getPassword());

        User user = new User();

        user.setUsername(dto.getUsername());
        user.setPassword(encodedPassword);
        user.setRole("USER");
        User savedUser = userRepository.save(user);

        return convertTODTO(savedUser);
    }

    public LoginResponseDTO login(LoginRequestDTO dto){
        Authentication authentication =
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getUsername(),
                        dto.getPassword()
                )
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String token = jwtService.generateToken(userDetails);

        return new LoginResponseDTO(token);

    }

}
