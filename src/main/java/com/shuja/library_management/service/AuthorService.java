package com.shuja.library_management.service;

import com.shuja.library_management.dto.AuthorRequestDTO;
import com.shuja.library_management.dto.AuthorResponseDTO;
import com.shuja.library_management.exception.AuthorNotFoundException;
import com.shuja.library_management.model.Author;
import com.shuja.library_management.model.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorResponseDTO createAuthor(AuthorRequestDTO dto){
        if (authorRepository.existsByEmail(dto.getEmail())){
            throw new RuntimeException("Author already exists");
        }

        Author author = new Author();

        author.setName(dto.getName());
        author.setEmail(dto.getEmail());
        author.setCountry(dto.getCountry());

        Author savedAuthor = authorRepository.save(author);

        return convertToDTO(savedAuthor);
    }

    public AuthorResponseDTO getAuthorById(Integer id){
        Author author = authorRepository.findById(id)
                .orElseThrow(()->
                        new AuthorNotFoundException("Author not found"));

        return convertToDTO(author);
    }

    public List<AuthorResponseDTO> getAllAuthors(){
        return authorRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }


    public AuthorResponseDTO convertToDTO(Author author){
        return new AuthorResponseDTO(
                author.getName(),
                author.getEmail(),
                author.getCountry()
        );
    }


}
