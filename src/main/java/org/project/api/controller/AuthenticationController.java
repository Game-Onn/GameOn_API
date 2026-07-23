package org.project.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    /**
     * This is a welcome message.
     * @return a welcome string.
     */
    @GetMapping("/")
    public String getHello(){
        return "Welcome";
    }

    /**
     * This method handles user login.
     * It takes a map of credentials and returns a token.
     * @param credentials The user's credentials.
     * @return A map containing a JWT token.
     */
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> credentials) {
        // In a real application, you would validate the credentials against a database.
        // For this example, we'll just generate a random token.
        String username = credentials.get("username");
        String password = credentials.get("password");

        // Dummy validation
        if (isValid(username, password)) {
            String token = generateToken(username);
            return Map.of("token", token);
        } else {
            // In a real app, you'd throw an authentication exception.
            return Map.of("error", "Invalid credentials");
        }
    }

    /**
     * Generates a dummy JWT token.
     * @param username The username to include in the token.
     * @return A dummy JWT token.
     */
    private String generateToken(String username) {
        // This is a very simplified and insecure way to generate a token.
        // In a real application, use a proper JWT library.
        String header = "{\"alg\":\"HS256\",\"typ\":\"JWT\"}";
        String payload = "{\"username\":\"" + username + "\",\"exp\":" + (System.currentTimeMillis() / 1000 + 3600) + "}";
        String signature = "dummy-signature"; // In a real app, this would be a cryptographic signature.
        return java.util.Base64.getEncoder().encodeToString(header.getBytes()) + "." +
               java.util.Base64.getEncoder().encodeToString(payload.getBytes()) + "." +
               signature;
    }

    /**
     * Validates the user's credentials.
     * @param username The username.
     * @param password The password.
     * @return true if the credentials are valid, false otherwise.
     */
    private boolean isValid(String username, String password) {
        // Dummy validation logic.
        // In a real app, you'd check against a database.
        return username != null && !username.isEmpty() && password != null && !password.isEmpty();
    }
}