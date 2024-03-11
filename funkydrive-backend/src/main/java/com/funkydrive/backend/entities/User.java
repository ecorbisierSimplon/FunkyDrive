package com.funkydrive.backend.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "email_ok")
    private boolean emailOk;

    @Column(name = "key")
    private String key;

    @Column(name = "password")
    private String password;

    @Column(name = "key_temp")
    private String keyTemp;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;

    @Column(name = "date_create")
    private LocalDateTime dateCreate = LocalDateTime.now();

    public User() {

    }

    public Long getId() {
	return id;
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

    public boolean isEmailOk() {
	return emailOk;
    }

    public void setEmailOk(boolean emailOk) {
	this.emailOk = emailOk;
    }

    public String getKey() {
	return key;
    }

    public void setKey(String key) {
	this.key = key;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getKeyTemp() {
	return keyTemp;
    }

    public void setKeyTemp(String keyTemp) {
	this.keyTemp = keyTemp;
    }

    public void setRole(Role role) {
	this.role = role;
    }

}
