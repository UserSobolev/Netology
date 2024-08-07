package ru.netology.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredentials(InvalidCredentials invalidCredentials) {
        return new ResponseEntity<>(invalidCredentials.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedUser(UnauthorizedUser unauthorizedUser) {
        return new ResponseEntity<>(unauthorizedUser.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
