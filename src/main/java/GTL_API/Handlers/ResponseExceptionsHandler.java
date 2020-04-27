package GTL_API.Handlers;

import GTL_API.Exceptions.CreationException;
import GTL_API.Exceptions.DuplicateException;
import GTL_API.Exceptions.NotFoundException;
import GTL_API.Exceptions.UpdateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@EnableWebMvc
public class ResponseExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value= NotFoundException.class)
    protected ResponseEntity<Object> handleNotFoundException(NotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value= DuplicateException.class)
    protected ResponseEntity<Object> handleDuplicateException(DuplicateException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value= CreationException.class)
    protected ResponseEntity<Object> handleCreationException(CreationException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(value= UpdateException.class)
    protected ResponseEntity<Object> handleUpdateException(UpdateException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }
}
