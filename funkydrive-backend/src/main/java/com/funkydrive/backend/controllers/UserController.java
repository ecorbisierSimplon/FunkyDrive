
package com.funkydrive.backend.controllers;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.funkydrive.backend.dto.CreateUser;
import com.funkydrive.backend.dto.UpdateUser;
import com.funkydrive.backend.entities.User;
import com.funkydrive.backend.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
	this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public long create(@RequestBody @Valid CreateUser inputs) throws BadRequestException {
	return userService.createUser(inputs);

    }

    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
	return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid UpdateUser input) {

	userService.updateUser(id, input);
    }
}