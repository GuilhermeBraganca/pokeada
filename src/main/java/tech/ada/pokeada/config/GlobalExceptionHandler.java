package tech.ada.pokeada.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import tech.ada.pokeada.exceptions.StandardError;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public StandardError badRequestHandler(MethodArgumentNotValidException e) {
        StandardError standardError = new StandardError();
        standardError.setMessage(e.getFieldError().getDefaultMessage());
        standardError.setStatus(HttpStatus.BAD_REQUEST.value());
        standardError.setTimestamp(System.currentTimeMillis());
        return standardError;
    }


}
