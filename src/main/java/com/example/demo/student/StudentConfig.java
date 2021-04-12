package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student mike = new Student("fake_Mike","fake_mike@gmail.com", LocalDate.of(2000,12,12));
            Student kate = new Student("fake_Kate","fake_kate@gmail.com", LocalDate.of(2004,01,01));
            studentRepository.saveAll(Arrays.asList(mike,kate));
        };
    }
}
