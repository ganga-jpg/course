package com.example.learning.springboot.springbootdemo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.learning.springboot.springbootdemo.bean.Course;
import com.example.learning.springboot.springbootdemo.repository.CourseRepository;



@RestController
public class RestCoursesController {
	@Autowired
	private CourseRepository repository;
	@GetMapping("/courses")
	public List<Course> getAllCourses(){
		return repository.findAll();
		//return Arrays.asList(new Course(1,"Learn Microservices","28 Minutes"));
	}
	
	@GetMapping("/courses/{id}")
	public Course getCourse(@PathVariable long id){
		 Optional<Course> findById = repository.findById(id);
		//return Arrays.asList(new Course(1,"Learn Microservices","28 Minutes"));
		 if(findById.isEmpty())
		 {
			 throw new RuntimeException("Course is not found for id:" + id);
		 }
		return findById.get();
	}
	
	@PostMapping("/course")
	public void CreateCourse(@RequestBody Course course) {
		repository.save(course);
	}
	
	@PutMapping("/course/{id}")
	public void updateCourse(@RequestBody Course course) {
		long id = course.getId();
		Optional<Course> findById = repository.findById(id);
		if(findById.isEmpty())
		{
			throw new RuntimeException("Course is not found for id:" + id);
		}
		repository.save(course);
	}
	
	@DeleteMapping("course/{id}")
	public void deleteCourse(@PathVariable long id)
	{
		Optional<Course> findById = repository.findById(id);
		if(findById.isEmpty())
		{
			throw new RuntimeException("Course is not found for id:" + id);
		}
		repository.deleteById(id);
		
	}

}
