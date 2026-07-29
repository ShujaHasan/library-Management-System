package mapper;

import com.shuja.library_management.dto.BookResponseDTO;
import com.shuja.library_management.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookResponseDTO toDTO(Book book);
}
