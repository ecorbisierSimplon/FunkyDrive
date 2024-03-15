package com.funkydrive.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateFolder {
    @NotBlank
    @Size(max = 50)
    private String fileName;

    public CreateFolder() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
