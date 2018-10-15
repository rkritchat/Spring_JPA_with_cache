package com.example.testcache.resource;

import com.example.testcache.model.Student;
import com.example.testcache.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentResource {
    private StudentService studentService;

    @Autowired
    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @PutMapping(path = "/add")
    public String addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PostMapping("/id")
    public Student findByStudentId(@RequestBody Student student) {
        return studentService.findStudentById(student);
    }

    @PatchMapping
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping
    public String deleteStudent(@RequestBody Student student) {
        return studentService.deleteStudent(student);
    }
}
