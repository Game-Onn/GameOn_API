package org.project.api.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Main application class for the GameOn API.
 * This class is the entry point for the Spring Boot application.
 *
 * @author Your Name
 * @version 1.1
 */
@SpringBootApplication
@ComponentScan("org.project.api")
@RestController
public class GameOnApplicationStartUp {

    /**
     * The main method that starts the Spring Boot application.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        // This is where the magic begins.
        SpringApplication.run(GameOnApplicationStartUp.class, args);
    }

    /**
     * A simple health check endpoint.
     * @return A status message.
     */
    @GetMapping("/health")
    public String healthCheck() {
        return "{\"status\": \"UP\"}";
    }
}