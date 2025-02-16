package uz.nodir.beanregisterdemo.configuration;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

/**
 * @author: PC
 * @date: 16.02.2025
 * @group: DavrCoders
 **/

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException m) {
        return ResponseEntity.ok(
                Map.of(
                        "error", m.getMessage()
                )
        );
    }
}
