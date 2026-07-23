package org.project.api.service;

import org.project.api.dto.UserDto;

import java.util.List;

/**
 * Service interface for user-related operations.
 */
public interface UserService {

    /**
     * Retrieves all users.
     *
     * @return A list of all users.
     */
    List<UserDto> getAllUsers();

    /**
     * Retrieves a user by their ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The user's data.
     */
    UserDto getUserById(String id);

    /**
     * Updates an existing user.
     *
     * @param id The ID of the user to update.
     * @param userDto The new user data.
     * @return The updated user data.
     */
    UserDto updateUser(String id, UserDto userDto);

    /**
     * Deletes a user by their ID.
     *
     * @param id The ID of the user to delete.
     */
    void deleteUser(String id);
}
