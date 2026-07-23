package org.project.api.repository;

import org.project.api.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for user data with delete.
 */
public interface UserRepository {

    /**
     * Finds all users.
     *
     * @return A list of all users.
     */
    List<User> findAll();

    /**
     * Finds a user by their ID.
     *
     * @param id The ID of the user to find.
     * @return An Optional containing the user if found, or empty otherwise.
     */
    Optional<User> findById(String id);

    /**
     * Saves a user.
     *
     * @param user The user to save.
     */
    void save(User user);

    /**
     * Deletes a user.
     *
     * @param user The user to delete.
     */
    void delete(User user);
}
