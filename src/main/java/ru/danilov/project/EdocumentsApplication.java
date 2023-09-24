package ru.danilov.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"ru.*"})
public class EdocumentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EdocumentsApplication.class, args);

    }
}
