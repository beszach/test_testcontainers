package com.example.test_post_db.init;

import com.example.test_post_db.model.Student;
import com.example.test_post_db.repository.StudentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Log4j2
public class Init {

    @Autowired
    StudentRepository studentRepository;

    @PostConstruct
    public void initStudents(){
        Student student1 = new Student("studen1");
        Student student2 = new Student("studen2");
        Student student3 = new Student("studen3");

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);

        log.info("Add student 1: "+ student1);
    }
}
