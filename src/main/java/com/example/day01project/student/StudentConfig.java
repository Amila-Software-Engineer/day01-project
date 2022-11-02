package com.example.day01project.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.JANUARY;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student mariam =  new Student(
                    "Mariam",
                    "mariam@gmail.com",
                    LocalDate.of(2000, JANUARY,21)

            );

            Student alex =  new Student(
                    "alex",
                    "alex@gmail.com",
                    LocalDate.of(1993, JANUARY,21)
            );
            studentRepository.saveAll(
              List.of(mariam, alex)
            );
        };
    }
}
