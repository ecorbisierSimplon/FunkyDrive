package com.funkydrive.backend.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.funkydrive.backend.entities.createFolder;

import jakarta.validation.Valid;

@RestController
public class folderController {
    @PostMapping("/create_folder")
    public String postFolder(@Valid @RequestBody createFolder myFolder){
        return "Folder created";
    }
    
}
