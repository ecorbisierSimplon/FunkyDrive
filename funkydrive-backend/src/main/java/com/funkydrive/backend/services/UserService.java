
package com.funkydrive.backend.services;

import org.springframework.stereotype.Service;

import com.funkydrive.backend.dto.CreateUser;
import com.funkydrive.backend.dto.UpdateUser;
import com.funkydrive.backend.entities.User;
import com.funkydrive.backend.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    // @Autowired
    public UserService(UserRepository userRepository) {
	this.userRepository = userRepository;
    }

    public long createUser(CreateUser inputs) {
	User user = new User();
	user.setFirstName(inputs.getFirstName());
	user.setLastName(inputs.getLastName());
	user.setEmail(inputs.getEmail());
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

	userRepository.save(user);
    }
}
