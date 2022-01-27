package com.example.test_post_db.repository;

import com.example.test_post_db.model.Student;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;


@Testcontainers
@SpringBootTest
@ActiveProfiles("test")
@Log4j2
public class TestRep {

    @Container
    public static PostgreSQLContainer container = new PostgreSQLContainer("postgres:14.1")
            .withDatabaseName("test_db2")
            .withUsername("postgres")
            .withPassword("qwerty");

    @Autowired
    StudentRepository studentRepository;

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry){
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
    }



    @Test
    public void load(){
        System.out.println("context loads");
    }

    @Test
    public void student_id_should_be_not_null(){
        Student student = new Student("Adam");
        studentRepository.save(student);
        log.info("Student: "+student);
    }

    @Test
    public void get_all(){
        List<Student> studentList = studentRepository.findAll();
        log.info("Student list: "+studentList);
    }
}
