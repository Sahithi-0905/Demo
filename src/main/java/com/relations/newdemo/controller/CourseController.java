package com.relations.newdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relations.newdemo.dto.CourseDto;
import com.relations.newdemo.entity.Course;
import com.relations.newdemo.entity.Student;
import com.relations.newdemo.service.CourseService;

@RestController
@RequestMapping("/api/course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@PostMapping
	public Course saveCourse(@RequestBody Course course) {
		return courseService.saveCourse(course);
	}
	
	@PutMapping("/{courseid}")
	public Course updateCourseById(@PathVariable ("courseid") Long id,@RequestBody CourseDto coursedto) {
		return courseService.updateCourseById(coursedto,id);
		
	}
	
	@DeleteMapping("/{courseid}")
	public  String deleteCourse(@PathVariable ("courseid") Long id) {
		courseService.deleteCourse(id);
		return "deleted";
	}
	
	@GetMapping
	public List<Course> getAllCourses(){
		System.out.println("================");
		return courseService.getAllCourses();
		
	}
	
	@GetMapping("/getstud/{id}") //show all the student names having same courseid 
	public List<String> getAllStudentsInCourse(@PathVariable ("id") Long id){
		return courseService.getAllStudentsInCourse(id);
	}
	
	@GetMapping("/getstuds/{studentId}") //show all the  names course for a student
	public List<Course> getAllCoursesByStudentId(@PathVariable ("studentId") Long id){
		return courseService.getAllCoursesByStudentId(id);
	}
	
}
