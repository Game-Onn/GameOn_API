package org.project.api.repository.impl;

import org.project.api.model.User;
import org.project.api.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Mock implementation of the UserRepository with delete.
 */
@Repository
public class MockUserRepository implements UserRepository {

    private final List<User> users = new ArrayList<>();

    public MockUserRepository() {
        // Add some dummy users for testing purposes
        users.add(new User("1", "Alice", "alice@example.com", "password"));
        users.add(new User("2", "Bob", "bob@example.com", "password"));
        users.add(new User("3", "Charlie", "charlie@example.com", "password"));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public Optional<User> findById(String id) {
        return users.stream()
                .filter(user -> id.equals(user.getId()))
                .findFirst();
    }

    @Override
    public void save(User user) {
        findById(user.getId()).ifPresent(users::remove);
        users.add(user);
    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }
}
