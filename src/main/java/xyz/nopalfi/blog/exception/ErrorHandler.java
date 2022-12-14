package xyz.nopalfi.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResourceNotFoundException resourceNotFoundException(ResourceNotFoundException e) {
        return e;
    }

    @ExceptionHandler(ResourceAlreadyExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResourceAlreadyExistException resourceAlreadyExistException(ResourceAlreadyExistException e) {
        return e;
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public UsernameNotFoundException usernameNotFoundException(UsernameNotFoundException e) {
        return e;
    }
}
