package com.relations.newdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relations.newdemo.dto.CourseDto;
import com.relations.newdemo.dto.AllSubDto;
import com.relations.newdemo.entity.Course;
import com.relations.newdemo.service.CourseService;
import com.relations.newdemo.service.DtoService;

@RestController
@RequestMapping("/api/coursedto")
public class DtoCourseController {
	@Autowired
	private CourseService courseService;
	@Autowired
	private DtoService dtoService;
	
	@PostMapping
	public Course saveCourseDto(@RequestBody CourseDto courseDto) {
		return courseService.saveCourseDto(courseDto);
	}
    
	@GetMapping("/show")
	public List<AllSubDto> getAllCoursesAndListSubjects(){
		return dtoService.getAllCoursesAndListSubjects();
		
	}
}
