package com.funkydrive.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateUser {
    @NotBlank
    @Size(max = 50)
    private String firstName;

    @NotBlank
    @Size(max = 50)
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @Size(min = 8)
    private String pass;

    @NotBlank
    @Size(min = 8)
    private String password;

    @NotBlank
    @Size(min = 8)
    private String passwordValidation;

    @NotBlank
    @Size(min = 8)
    private String password;

    public CreateUser() {
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

<<<<<<< HEAD
    public String getPass() {
	return pass;
    }

    public String getPasswordValidation() {
	return passwordValidation;
    }
=======
    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

>>>>>>> e8f30c9434cc8947c82315a838973b98171dd97e
}
