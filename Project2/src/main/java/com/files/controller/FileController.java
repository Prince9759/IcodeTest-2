package com.files.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

//import com.files.entity.File;
import java.io.File;


import com.files.entity.UserFile;
import com.files.service.FileExcelService;
import com.files.service.FileService;

import java.io.IOException;
import java.util.List;


@RestController
@CrossOrigin
public class FileController
{
	 @Autowired
	    private FileService fs; 

	    @Autowired
	    private FileExcelService fes;

	    @GetMapping
	    public List<UserFile> getAllEntities() {
	        return fs.getAllFile();
	    }

	    @GetMapping("/download-template")
	    public ResponseEntity<ByteArrayResource> downloadTemplate() {
	        List<UserFile> entities = fs.getAllFile();
	        ByteArrayResource resource = fes.generateTemplate(entities);

	        
	        return ResponseEntity.ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=your_template.xlsx")
	                .contentType(MediaType.APPLICATION_OCTET_STREAM)
	                .body(resource);
	    }

	    @PostMapping("/upload-template")
	    public ResponseEntity<String> uploadTemplate(@RequestParam("file") MultipartFile file) {
	    	 try {
	         
	             if (file.isEmpty()) {
	                 return ResponseEntity.badRequest().body("Please select a file to upload");
	             }

	          
	             String fileName = file.getOriginalFilename();
	             String filePath = "D:\\DUCAT\\SpringBoot\\Code\\FrontEnd" + File.separator + fileName;
	             File dest = new File(filePath);
	             file.transferTo(dest);

	             return ResponseEntity.ok("File uploaded successfully. Path: " + filePath);
	         } catch (IOException e) {
	             e.printStackTrace();
	             return ResponseEntity.status(500).body("Error uploading file: " + e.getMessage());
	         }
	     }
	 
	    
	    @GetMapping("/get")
	    public ResponseEntity<List<UserFile>> getAllExcelData() {
	        List<UserFile> allExcelData = fs.getAllFile();
	        return ResponseEntity.ok(allExcelData);
	    }
	


	

	}