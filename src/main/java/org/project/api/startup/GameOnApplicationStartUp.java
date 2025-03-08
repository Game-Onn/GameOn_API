package org.project.api.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("org.project.api")
@SpringBootApplication
public class GameOnApplicationStartUp {

    public static void main(String[] args) {
        SpringApplication.run(GameOnApplicationStartUp.class, args);
    }
}
