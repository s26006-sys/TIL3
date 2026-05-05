package com.example.crudboar.dto;

import com.example.crudboar.entity.Boardentity;
import java.time.LocalDateTime;

// 파일 이름이 responsedto.java 이므로 소문자로 맞춰줍니다.
public record responsedto(
        Long idx,
        String title,
        String content,
        LocalDateTime createAt,
        LocalDateTime updateAt
) {
    // Entity(DB 데이터)를 받아서 DTO(택배 상자)로 변환해주는 생성자입니다.
    public responsedto(Boardentity entity) {
        this(
                entity.getIdx(),
                entity.getTitle(),
                entity.getContent(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}