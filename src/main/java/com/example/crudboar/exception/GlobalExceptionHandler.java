package com.example.crudboar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // 모든 컨트롤러의 에러를 여기서 다 처리한다
public class GlobalExceptionHandler {

    // 서비스에서 던진 메시지를 여기서 처리함
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException e) {
        Map<String, String> response = new HashMap<>();

        response.put("status", "404");
        response.put("message", e.getMessage()); // 서비스에서 쓴 에러 문구가 여기 들어감

        // 실제로 404 Not Found 상태코드를 보냄
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}