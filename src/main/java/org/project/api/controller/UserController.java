package org.project.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private final List<Map<String, String>> users = new ArrayList<>();

    public UserController() {
        // Add some dummy users
        users.add(Map.of("id", "1", "name", "Alice", "email", "alice@example.com"));
        users.add(Map.of("id", "2", "name", "Bob", "email", "bob@example.com"));
        users.add(Map.of("id", "3", "name", "Charlie", "email", "charlie@example.com"));
    }

    /**
     * This method retrieves all users.
     * @return A list of all users.
     */
    @GetMapping("/")
    public List<Map<String, String>> getAllUsers() {
        return users;
    }

    /**
     * This method retrieves a user by their ID.
     * @param id The ID of the user to retrieve.
     * @return The user's data, or null if not found.
     */
    @GetMapping("/{id}")
    public Map<String, String> getUserById(@PathVariable String id) {
        return users.stream()
                .filter(user -> id.equals(user.get("id")))
                .findFirst()
                .orElse(null);
    }
}