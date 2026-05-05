package com.example.crudboar.repository;

import com.example.crudboar.entity.Boardentity; // 여기 e를 E로 바꿔보세요
import org.springframework.data.jpa.repository.JpaRepository;

public interface boardrepository extends JpaRepository<Boardentity, Long> {
    // 내용 비어있어도 됨
}