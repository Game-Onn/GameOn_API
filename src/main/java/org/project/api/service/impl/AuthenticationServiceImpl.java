package org.project.api.service.impl;

import org.project.api.dto.LoginRequest;
import org.project.api.dto.RegistrationRequest;
import org.project.api.model.User;
import org.project.api.repository.UserRepository;
import org.project.api.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

/**
 * Implementation of the AuthenticationService interface.
 * This service handles the business logic for user authentication and registration.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    @Autowired
    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Authenticates a user based on their credentials.
     * In a real application, this method would involve more complex validation,
     * such as checking against a database and using a secure password hashing mechanism.
     * @param loginRequest The login request containing the user's credentials.
     * @return A map containing a JWT token if authentication is successful.
     */
    @Override
    public Map<String, String> login(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        // Dummy validation. In a real app, you'd check the password hash.
        if (isValid(username, password)) {
            String token = generateToken(username);
            return Map.of("token", token);
        } else {
            // In a real app, you'd throw an authentication exception.
            return Map.of("error", "Invalid credentials");
        }
    }

    /**
     * Registers a new user.
     * This method creates a new user and saves it to the repository.
     * @param registrationRequest The registration request containing user data.
     */
    @Override
    public void register(RegistrationRequest registrationRequest) {
        // In a real application, you would perform validation,
        // such as checking if the username or email is already taken.
        String id = UUID.randomUUID().toString();
        User newUser = new User(
                id,
                registrationRequest.getUsername(),
                registrationRequest.getEmail(),
                registrationRequest.getPassword() // In a real app, you'd hash the password
        );
        userRepository.save(newUser);
    }

    /**
     * Generates a dummy JWT token.
     * This is a simplified and insecure way to generate a token.
     * In a real application, use a proper JWT library like jjwt.
     * @param username The username to include in the token.
     * @return A dummy JWT token.
     */
    private String generateToken(String username) {
        String header = "{\"alg\":\"HS256\",\"typ\":\"JWT\"}";
        String payload = "{\"username\":\"" + username + "\",\"exp\":" + (System.currentTimeMillis() / 1000 + 3600) + "}";
        String signature = "dummy-signature"; // In a real app, this would be a cryptographic signature.
        return java.util.Base64.getEncoder().encodeToString(header.getBytes()) + "." +
               java.util.Base64.getEncoder().encodeToString(payload.getBytes()) + "." +
               signature;
    }

    /**
     * Validates the user's credentials.
     * This is a dummy validation method. In a real app, you'd compare a hashed password.
     * @param username The username.
     * @param password The password.
     * @return true if the credentials are valid, false otherwise.
     */
    private boolean isValid(String username, String password) {
        return username != null && !username.isEmpty() && password != null && !password.isEmpty();
    }
}
