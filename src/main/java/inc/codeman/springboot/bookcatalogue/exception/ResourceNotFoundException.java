package inc.codeman.springboot.bookcatalogue.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String fieldName;
    private int fieldValue;
    private String resourceName;
    public  ResourceNotFoundException(String resourceName,String fieldName,int fieldValue){
        super(String.format("%s not found, with %s : '%s'",resourceName,fieldName,fieldValue));
    }

}
