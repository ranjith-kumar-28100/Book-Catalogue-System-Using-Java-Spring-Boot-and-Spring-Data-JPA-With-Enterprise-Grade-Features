package inc.codeman.springboot.bookcatalogue.service;

import inc.codeman.springboot.bookcatalogue.entity.BookInfo;
import inc.codeman.springboot.bookcatalogue.dto.BookInfoDTO;

import java.util.List;

public interface BookInfoService {
    BookInfoDTO createBook(BookInfoDTO bookInfo);
    BookInfoDTO getBookById(int id);
    List<BookInfoDTO> getAllBooks();
    BookInfoDTO updateBookInfo(int id,BookInfoDTO bookInfo);

    void deleteBookInfo(int id);
}
