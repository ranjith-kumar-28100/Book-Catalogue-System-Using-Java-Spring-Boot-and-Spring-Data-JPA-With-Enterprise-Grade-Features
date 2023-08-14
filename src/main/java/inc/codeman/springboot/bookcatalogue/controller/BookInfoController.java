package inc.codeman.springboot.bookcatalogue.controller;

import inc.codeman.springboot.bookcatalogue.service.impl.BookInfoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import inc.codeman.springboot.bookcatalogue.dto.BookInfoDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "CRUD REST APIs for Book Info Catalogue System", description = "REST APIs for Book Info Catalogue System to perform create, update, read and delete")
@RestController
@RequestMapping("/api/v1/books")
public class BookInfoController {
    private BookInfoServiceImpl service;

    @Autowired
    public BookInfoController(BookInfoServiceImpl service) {
        this.service = service;
    }

    @Operation(summary = "CREATE", description = "Endpoint for creating new BookInformation")
    @ApiResponse(responseCode = "201", description = "Book Info Created Sucessfully")
    @PostMapping("create")
    public ResponseEntity<BookInfoDTO> createBookInfo(@Valid @RequestBody BookInfoDTO bookInfo) {
        BookInfoDTO result = service.createBook(bookInfo);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @Operation(summary = "GET BY ID", description = "Endpoint for getting  BookInformation by id")
    @ApiResponse(responseCode = "200", description = "Book Info fetched Sucessfully")
    @GetMapping("{id}")
    public ResponseEntity<BookInfoDTO> getBookInfoById(@PathVariable int id) {
        BookInfoDTO result = service.getBookById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping()
    @Operation(summary = "GET ALL", description = "Endpoint for getting all BookInformation")
    @ApiResponse(responseCode = "200", description = "Book Infos fetched Sucessfully")
    public ResponseEntity<List<BookInfoDTO>> getBooks() {
        List<BookInfoDTO> result = service.getAllBooks();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("{id}")
    @Operation(summary = "EDIT", description = "Endpoint for editing  BookInformation by id")
    @ApiResponse(responseCode = "200", description = "Book Info updated Sucessfully")
    public ResponseEntity<BookInfoDTO> updateBookById(@PathVariable int id, @Valid @RequestBody BookInfoDTO bookInfo) {
        BookInfoDTO result = service.updateBookInfo(id, bookInfo);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "DELETE BY ID", description = "Endpoint for deleting  BookInformation by id")
    @ApiResponse(responseCode = "200", description = "Book Info Deleted Sucessfully")
    public ResponseEntity<String> deleteBookById(@PathVariable int id) {
        service.deleteBookInfo(id);
        return new ResponseEntity<>("Book Deleted Sucessfully", HttpStatus.OK);
    }

    // @ExceptionHandler(ResourceNotFoundException.class)
    // public ResponseEntity<ErrorDetails>
    // handleResourceNotFoundException(ResourceNotFoundException exception,
    // WebRequest webRequest){
    // ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
    // exception.getMessage(),webRequest.getDescription(false),"BOOK_NOT_FOUND");
    // return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    // }
}
