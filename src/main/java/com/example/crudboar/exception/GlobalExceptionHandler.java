package com.example.crudboar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // 모든 컨트롤러의 에러를 여기서 다 낚아챌 거야!
public class GlobalExceptionHandler {

    // 우리가 서비스에서 던진 IllegalArgumentException("메시지")를 여기서 처리함
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException e) {
        Map<String, String> response = new HashMap<>();

        // JSON 응답의 모양을 만드는 중
        response.put("status", "404");
        response.put("message", e.getMessage()); // 서비스에서 쓴 에러 문구가 여기 들어감

        // 실제로 404 Not Found 상태코드를 보냄
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}