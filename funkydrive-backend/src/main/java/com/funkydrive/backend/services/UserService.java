package com.funkydrive.backend.services;

import org.apache.coyote.BadRequestException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.funkydrive.backend.dto.CreateUser;
import com.funkydrive.backend.dto.UpdateUser;
import com.funkydrive.backend.entities.Role;
import com.funkydrive.backend.entities.User;
import com.funkydrive.backend.repositories.RoleRepository;
import com.funkydrive.backend.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
	this.userRepository = userRepository;
	this.roleRepository = roleRepository;
    }

    public long createUser(CreateUser inputs) throws BadRequestException {
	long count = userRepository.count();

	if (count == 0 && !inputs.getPass().equals(System.getenv("PASS"))) {
	    throw new BadRequestException("1st login password or email are incorrect!");
	}

	if (!inputs.getPassword().equals(inputs.getPasswordValidation())) {
	    throw new BadRequestException("The password isn't identical!");
	}
	Role role = count == 0 ? roleRepository.findById(1L).orElseThrow() : roleRepository.findById(2L).orElseThrow();
	User user = new User();
	user.setFirstName(inputs.getFirstName());
	user.setLastName(inputs.getLastName());
	user.setEmail(inputs.getEmail());
	user.setRole(role);

	String rawPassword = inputs.getPassword();
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	String hashedPassword = passwordEncoder.encode(rawPassword);
	user.setPassword(hashedPassword);

	userRepository.save(user);

	return user.getId();
    }

    public User getUserById(Long id) {
	return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }

    // Méthode pour mettre à jour un utilisateur existant
    public void updateUser(long id, UpdateUser input) {
	User user = getUserById(id);

	user.setFirstName(input.getFirstName());
	user.setLastName(input.getLastName());
	user.setEmail(input.getEmail());

	if (input.getPassword() != null) {
	    String rawPassword = input.getPassword();
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String hashedPassword = passwordEncoder.encode(rawPassword);
	    user.setPassword(hashedPassword);
	}
	// Add any other necessary update logic here
	userRepository.save(user);
    }
}