package com.shuja.library_management.service;

import com.shuja.library_management.dto.BookRequestDTO;
import com.shuja.library_management.dto.BookResponseDTO;
import com.shuja.library_management.exception.BookNotFoundException;
import com.shuja.library_management.model.Author;
import com.shuja.library_management.model.Book;
import com.shuja.library_management.model.repository.AuthorRepository;
import com.shuja.library_management.model.repository.BookRepository;
import mapper.BookMapper;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.bookMapper = bookMapper;
    }


    public BookResponseDTO addBook(BookRequestDTO dto){
        Author author = authorRepository.findById(dto.getAuthorId())
                .orElseThrow(()-> new RuntimeException("Author ID" + dto.getAuthorId() + " does not exist!"));

        Book book = new Book();

        book.setTitle(dto.getTitle());
        book.setIsbn(dto.getIsbn());

        // 4. Set the managed Author relationship
        book.setAuthor(author);

        // 5. Save the Book entity to the database
        Book savedBook = bookRepository.save(book);

        // 6 & 7. Convert the saved entity into a BookResponseDTO and return it
        return bookMapper.toDTO(savedBook);

    }

    private BookResponseDTO convertToDTO(Book book){
        return new BookResponseDTO(
                book.getId(),
                book.getTitle(),
                book.getIsbn(),
                book.getAuthor().getName()
        );
    }

    public List<BookResponseDTO> getAllBooks(){

        List<Book> books = bookRepository.findAll();

        return bookMapper.toDTOList(books);

    }

    public BookResponseDTO getBookById(Integer id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book ID" + id + "not found"));

        return convertToDTO(book);
    }


    public BookResponseDTO updateBook(Integer id, BookRequestDTO dto){

        Book book = bookRepository.findById(id)
                .orElseThrow(()-> new BookNotFoundException("Book not found"));

        Author author = authorRepository.findById(dto.getAuthorId())
                .orElseThrow(()-> new AuthorNotFoundException("Author not found"));

        bookMapper.updateBookFromDTO(dto, book);

        book.setAuthor(author);

        Book updatedBook = bookRepository.save(book);

        return bookMapper.toDTO(updatedBook);

    }



}
