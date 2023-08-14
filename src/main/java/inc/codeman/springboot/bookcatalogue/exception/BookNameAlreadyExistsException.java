package inc.codeman.springboot.bookcatalogue.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class BookNameAlreadyExistsException extends RuntimeException{
private String message;

public BookNameAlreadyExistsException(String message){
    super((message));
    this.message = message;
}
}
