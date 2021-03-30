package org.example;
import org.example.entities.User;
import org.example.repositories.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleApplication {
    public ExampleApplication (UserRepo userRepo) {
        User dima = new User();
        dima.setFirstName("Sova");
        userRepo.save(dima);
        System.out.println(userRepo.findAllByFirstName("Sova"));
    }

    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }
}
