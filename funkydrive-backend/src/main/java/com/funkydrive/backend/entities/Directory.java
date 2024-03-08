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
@Table(name = "directories")

public class Directory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "id_directory")
    private int idDirectory = 0;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @Column(name = "date_create")
    private LocalDateTime dateCreate = LocalDateTime.now();

    @Column(name = "date_change")
    private LocalDateTime dateChange = LocalDateTime.now();

    public Directory() {
    }

    public Long getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getIdDirectory() {
	return idDirectory;
    }

    public void setIdDirectory(int idDirectory) {
	this.idDirectory = idDirectory;
    }

    public LocalDateTime getDateCreate() {
	return dateCreate;
    }

    public LocalDateTime getDateChange() {
	return dateChange;
    }

}