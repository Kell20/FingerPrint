package com.iot.FingerPrint.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
//Handling exception for invalid key
@RestControllerAdvice
public class InvalidExceptionHandle {
    @ExceptionHandler(InvalidApiKeyException.class)
    public ResponseEntity<Map<String,Object>> handleInvalidKey(InvalidApiKeyException ex){
        Map<String,Object>map=new HashMap<>();
        map.put("error: ",ex.getMessage());
        map.put("status code ", HttpStatus.NOT_FOUND.value());
        map.put("timestamp", Instant.now());

        return new ResponseEntity<>(map,HttpStatus.UNAUTHORIZED);
    }
}
class Data<T>{

}
