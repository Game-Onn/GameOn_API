package org.project.api.controller;

import jakarta.validation.Valid;
import org.project.api.dto.UserDto;
import org.project.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for user-related operations with update and delete.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Retrieves all users.
     *
     * @return A list of all users.
     */
    @GetMapping("/")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The user's data.
     */
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    /**
     * Updates an existing user.
     *
     * @param id The ID of the user to update.
     * @param userDto The new user data.
     * @return The updated user data.
     */
    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable String id, @Valid @RequestBody UserDto userDto) {
        return userService.updateUser(id, userDto);
    }

    /**
     * Deletes a user by their ID.
     *
     * @param id The ID of the user to delete.
     * @return A response entity with a success message.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
