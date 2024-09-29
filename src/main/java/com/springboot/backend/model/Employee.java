package com.springboot.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long emp_id;

    @Column(name = "name")
    public String emp_name;

    @Column(name = "age")
    public int emp_age;

    @Column(name = "email")
    public String emp_email;

}
