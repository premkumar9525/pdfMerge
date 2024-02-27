package com.example.demo.restcontroller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.helper.Constants;
@RestController

@RequestMapping("/pdf")
public class PdfMergeRestController {

    @PostMapping("/merge")
	public ResponseEntity<?> mergePdfDocuments(@RequestParam("file1") MultipartFile file1,
			@RequestParam("file2") MultipartFile file2) {
		try {
			PDFMergerUtility pdfMerger = new PDFMergerUtility();

			// Load the first PDF document
			pdfMerger.addSource(new ByteArrayInputStream(file1.getBytes()));

			// Load the second PDF document
			pdfMerger.addSource(new ByteArrayInputStream(file2.getBytes()));
			
		

			// Merge the documents
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			pdfMerger.setDestinationStream(outputStream);
			pdfMerger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
			
			String path = Constants.BASE_DIR + Constants.BANNER_LOCATION;
			String fname = Constants.getRandom()  + outputStream.toByteArray()+".pdf";
			String fileName = Constants.saveMultiPartFile(file1, path, fname);
			
			/*
			 * HttpHeaders headers = new HttpHeaders();
			 * headers.setContentType(MediaType.APPLICATION_PDF);
			 * headers.setContentDispositionFormData("filename", "merged.pdf");
			 */

			// Return the merged PDF as bytes
			return ResponseEntity.ok().header("Content-Type", "application/pdf").body(outputStream.toByteArray());

		} catch (IOException e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body("Error merging PDF documents");
		}
	}
}
