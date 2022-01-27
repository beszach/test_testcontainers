package com.example.test_post_db.repository;

import com.example.test_post_db.model.Student;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@SpringBootTest
public class TestRep2 {
    @Autowired
    StudentRepository studentRepository;

    @Test
    public void aa(){
        studentRepository.save(new Student("adan"));

    }
}
