package com.relations.newdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relations.newdemo.dto.StudDto;
import com.relations.newdemo.dto.StudentDetailsDto;
import com.relations.newdemo.entity.Student;
import com.relations.newdemo.entity.StudentDetails;
import com.relations.newdemo.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentDetailsController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public Student saveStudentAndStudentdetails(@RequestBody StudDto stud){
		return studentService.saveStudentAndStudentdetails(stud);
		
	}
	@GetMapping("/getall")
	public List<Student> getAllStudents (){
		return studentService.getAllStudents();
		
	}
	
	@GetMapping("/get/{id}")
	public Student getStudentsById (@PathVariable ("id") Long id){
		return studentService.getStudentsById(id);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudentById(@PathVariable ("id") Long id) {
		studentService.deleteStudentById(id);
		return "deleted successFully";
	}
	
	
	@GetMapping("/getdetails/{id}")//get student details by id
	public StudentDetails getStudentsDetailsById (@PathVariable ("id") Long id){
		return studentService.getStudentsDetailsById(id);
		
	}
}
