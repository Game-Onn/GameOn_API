package org.project.api.service;

import org.project.api.dto.LoginRequest;
import org.project.api.dto.RegistrationRequest;

import java.util.Map;

/**
 * Service interface for authentication-related operations.
 */
public interface AuthenticationService {

    /**
     * Authenticates a user and returns a token.
     * @param loginRequest The login request containing credentials.
     * @return A map containing a JWT token if authentication is successful.
     */
    Map<String, String> login(LoginRequest loginRequest);

    /**
     * Registers a new user.
     * @param registrationRequest The registration request containing user data.
     */
    void register(RegistrationRequest registrationRequest);
}
