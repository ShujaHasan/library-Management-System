package com.shuja.library_management.mapper;

import com.shuja.library_management.dto.BookRequestDTO;
import com.shuja.library_management.dto.BookResponseDTO;
import com.shuja.library_management.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(source = "author.name", target = "authorName")
    BookResponseDTO toDTO(Book book);

    List<BookResponseDTO> toDTOList(List<Book> books);

    Book toEntity(BookRequestDTO dto);

    void updateBookFromDTO(BookRequestDTO dto, @MappingTarget Book book);

}


