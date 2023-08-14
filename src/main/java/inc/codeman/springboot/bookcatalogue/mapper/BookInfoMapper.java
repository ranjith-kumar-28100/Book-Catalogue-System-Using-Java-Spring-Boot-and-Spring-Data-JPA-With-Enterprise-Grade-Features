package inc.codeman.springboot.bookcatalogue.mapper;

import inc.codeman.springboot.bookcatalogue.dto.BookInfoDTO;
import inc.codeman.springboot.bookcatalogue.entity.BookInfo;
import org.springframework.stereotype.Component;

@Component
public class BookInfoMapper {
public BookInfo mapDTOToEntity(BookInfoDTO bookInfoDTO){
    BookInfo bookInfo = new BookInfo();
    bookInfo.setId(bookInfoDTO.getId());
    bookInfo.setName(bookInfoDTO.getName());
    bookInfo.setYear(bookInfoDTO.getYear());
    bookInfo.setAuthors(bookInfoDTO.getAuthors());
    bookInfo.setRating(bookInfoDTO.getRating());
    bookInfo.setPageCount(bookInfoDTO.getPageCount());
    bookInfo.setPublisher(bookInfoDTO.getPublisher());
    return  bookInfo;
}
public BookInfoDTO mapEntityToDTO(BookInfo bookInfo){
    BookInfoDTO bookInfoDTO = new BookInfoDTO();
    bookInfoDTO.setId(bookInfo.getId());
    bookInfoDTO.setName(bookInfo.getName());
    bookInfoDTO.setYear(bookInfo.getYear());
    bookInfoDTO.setAuthors(bookInfo.getAuthors());
    bookInfoDTO.setRating(bookInfo.getRating());
    bookInfoDTO.setPageCount(bookInfo.getPageCount());
    bookInfoDTO.setPublisher(bookInfo.getPublisher());
    return  bookInfoDTO;

}
}
