package com.funkydrive.backend.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "rang")
    private int rang;

    @Column(name = "date_create")
    private LocalDateTime dateCreate = LocalDateTime.now();

    public Role() {

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

    public int getRang() {
	return rang;
    }

    public void setRang(int rang) {
	this.rang = rang;
    }

    public LocalDateTime getDateCreate() {
	return dateCreate;
    }
}
