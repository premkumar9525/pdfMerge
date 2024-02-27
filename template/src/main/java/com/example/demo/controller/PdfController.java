package com.example.demo.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.helper.Constants;
import com.example.demo.repo.PdfRepository;
import com.example.demo.service.PdfService;

@Controller
@RequestMapping("/pdf")
public class PdfController {

	@Autowired
	private PdfRepository pdfRepository;

	@Autowired
	PdfService pdfService;

	@GetMapping("/test")
	public String test() {
		return "pdf";
	}

	@PostMapping("/savepdf")
	public String meregepdf(@RequestParam("file1") MultipartFile file1, 
			@RequestParam("file2") MultipartFile file2,Model model)
			throws IOException {
		PDFMergerUtility mergepdf = new PDFMergerUtility();
		mergepdf.addSource(new ByteArrayInputStream(file1.getBytes()));
		mergepdf.addSource(new ByteArrayInputStream(file2.getBytes()));
		
		

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		mergepdf.setDestinationStream(outputStream);
		mergepdf.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
		
		String path = Constants.BASE_DIR + Constants.BANNER_LOCATION;
		String fname = Constants.getRandom()  + outputStream.toByteArray()+".pdf";
		String fileName = Constants.saveMultiPartFile(file1, path, fname);
		
		model.addAttribute("mergepdf",outputStream.toByteArray());	
		
		System.err.println(":::::::::::::"+outputStream.toByteArray());

		return "pdf";

	}

}
