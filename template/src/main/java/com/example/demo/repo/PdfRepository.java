package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.PdfSender;

public interface PdfRepository extends JpaRepository<PdfSender, Long> {

}
