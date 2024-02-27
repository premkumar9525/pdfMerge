package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PdfSender {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String pdf1;
	private String pdf2;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPdf1() {
		return pdf1;
	}
	public void setPdf1(String pdf1) {
		this.pdf1 = pdf1;
	}
	public String getPdf2() {
		return pdf2;
	}
	public void setPdf2(String pdf2) {
		this.pdf2 = pdf2;
	}
	
	

}
