package com.example.testcache.service;

import com.example.testcache.model.Student;
import com.example.testcache.repositories.LaptopRepository;
import com.example.testcache.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private LaptopRepository laptopRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, LaptopRepository laptopRepository) {
        this.studentRepository = studentRepository;
        this.laptopRepository = laptopRepository;
    }

    public String addStudent(Student student) {
        studentRepository.save(student);

        return "Added Successfully";
    }

    @Cacheable(value = "student",key = "#student.getId()",unless = "#result == null")
    public Student findStudentById(Student student) {
        return studentRepository.findById(student.getId());
    }

    @CachePut(value = "student", key = "#student.getId()")
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @CacheEvict(value = "student", key = "#student.getId()")
    @Transactional
    public String deleteStudent(Student student) {
        studentRepository.delete(student);
        laptopRepository.deleteLaptopByStudentIdIsNull();
        return "Deleted Successfully";
    }


}
