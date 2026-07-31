package com.shuja.library_management.service;

import com.shuja.library_management.dto.RegisterRequestDTO;
import com.shuja.library_management.dto.UserResponseDTO;
import com.shuja.library_management.exception.UsernameAlreadyExistsException;
import com.shuja.library_management.model.User;
import com.shuja.library_management.model.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public RegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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
}
