package com.example.crudboar.dto;

import com.example.crudboar.entity.Boardentity;
import java.time.LocalDateTime;

public record responsedto(
        Long idx,
        String title,
        String content,
        LocalDateTime createAt,
        LocalDateTime updateAt
) {
    // Entity(DB 데이터)를 받아서 DTO(택배 상자)로 변환해주는 생성자
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