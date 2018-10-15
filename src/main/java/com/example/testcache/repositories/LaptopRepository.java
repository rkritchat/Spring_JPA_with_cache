package com.example.testcache.repositories;

import com.example.testcache.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {

    void deleteLaptopByStudentIdIsNull();
}
