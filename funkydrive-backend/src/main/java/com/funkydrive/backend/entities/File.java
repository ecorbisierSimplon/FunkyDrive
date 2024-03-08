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
@Table(name = "files")

public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name_origin")
    private String fileNameOrigin;

    @Column(name = "file_name_server")
    private String fileNameServer;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_directory")
    private Directory directory;

    @Column(name = "date_create")
    private LocalDateTime dateCreate = LocalDateTime.now();

    @Column(name = "date_change")
    private LocalDateTime dateChange = LocalDateTime.now();

    public File() {

    }

    public Long getId() {
	return id;
    }

    public String getFileNameOrigin() {
	return fileNameOrigin;
    }

    public String getFileNameServer() {
	return fileNameServer;
    }

    public LocalDateTime getDateCreate() {
	return dateCreate;
    }

    public LocalDateTime getDateChange() {
	return dateChange;
    }

    public void setFileNameOrigin(String fileNameOrigin) {
	this.fileNameOrigin = fileNameOrigin;
    }

    public void setFileNameServer(String fileNameServer) {
	this.fileNameServer = fileNameServer;
    }

}
