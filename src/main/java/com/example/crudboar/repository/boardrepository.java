package com.example.crudboar.repository;

import com.example.crudboar.entity.Boardentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface boardrepository extends JpaRepository<Boardentity, Long> {

}