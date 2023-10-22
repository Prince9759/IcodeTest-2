package com.files.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.files.entity.UserFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
@Service
public class FileExcelService {
	public ByteArrayResource generateTemplate(List<UserFile> entities) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("UserFile");

       
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Id");
            headerRow.createCell(1).setCellValue("Firstname");
            headerRow.createCell(2).setCellValue("Lastname");
            headerRow.createCell(3).setCellValue("DOB");
            headerRow.createCell(4).setCellValue("City");
           
            int rowNum = 1;
            for (UserFile entity : entities) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(entity.getId());
                row.createCell(1).setCellValue(entity.getFirstname());
                row.createCell(2).setCellValue(entity.getLastname());
                row.createCell(3).setCellValue(entity.getDOB());
                row.createCell(4).setCellValue(entity.getCity());
            }

            
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return new ByteArrayResource(outputStream.toByteArray());
        } catch (IOException e) {

            throw new RuntimeException("Error generating Excel template", e);
        }
    }

    public void processTemplate(MultipartFile file) {
        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);

          
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                String id = row.getCell(0).getStringCellValue();
                String name = row.getCell(1).getStringCellValue();
       
            }
        } catch (IOException e) {
        
            throw new RuntimeException("Error processing uploaded Excel file", e);
        }
    }
}