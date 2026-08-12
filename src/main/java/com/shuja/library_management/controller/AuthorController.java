package com.shuja.library_management.controller;

import com.shuja.library_management.dto.AuthorRequestDTO;
import com.shuja.library_management.dto.AuthorResponseDTO;
import com.shuja.library_management.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/author")
    public AuthorResponseDTO createAuthor(@Valid @RequestBody AuthorRequestDTO authorRequestDTO){
        return authorService.createAuthor(authorRequestDTO);
    }

    @GetMapping("author/{id}")
    public AuthorResponseDTO getAuthorById(@PathVariable Integer id){
        return authorService.getAuthorById(id);
    }

    @GetMapping("author")
    public List<AuthorResponseDTO> getAllAuthors(){
        return authorService.getAllAuthors();
    }
}
