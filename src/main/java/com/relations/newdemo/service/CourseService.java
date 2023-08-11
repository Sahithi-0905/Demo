package com.relations.newdemo.service;

import java.util.List;

import com.relations.newdemo.dto.CourseDto;
import com.relations.newdemo.dto.AllSubDto;
import com.relations.newdemo.entity.Course;
import com.relations.newdemo.entity.Student;

public interface CourseService {

	public Course saveCourse(Course course);

	public List<Course> getAllCourses();

	public void deleteCourse(Long id);

	public Course updateCourseById(CourseDto coursedto,Long id);
	
//to save course using dto.
	public Course saveCourseDto(CourseDto courseDto);

	public List<String> getAllStudentsInCourse(Long id);

	public List<Course> getAllCoursesByStudentId(Long id);

	

	
}
