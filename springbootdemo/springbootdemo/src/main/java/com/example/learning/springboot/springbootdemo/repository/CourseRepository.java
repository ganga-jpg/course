package com.example.learning.springboot.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learning.springboot.springbootdemo.bean.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
