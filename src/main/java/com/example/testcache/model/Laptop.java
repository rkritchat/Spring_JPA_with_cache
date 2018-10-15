package com.example.testcache.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "laptop_name")
    private String laptopName;
    @Column(name = "laptop_price")
    private String laptopPrice;
    @Column(name = "student_id")
    private String studentId;
}
