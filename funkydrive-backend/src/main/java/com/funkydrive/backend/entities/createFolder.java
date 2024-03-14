package com.funkydrive.backend.entities;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Column;


@CrossOrigin(origins = "http//localhost:8000")
public class createFolder {


    private String fileName;

    private LocalDateTime dateCreate = LocalDateTime.now();

    private LocalDateTime dateChange = LocalDateTime.now();

    //constructeur 
    public createFolder() {  
    }

    public String getFileName() {
        return fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public LocalDateTime dateTimeCreate() {
        return dateCreate;
    }

    public LocalDateTime dateTimeChange() {
        return dateChange;
    }
}
