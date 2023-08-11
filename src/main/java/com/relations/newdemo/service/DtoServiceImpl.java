package com.relations.newdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relations.newdemo.dto.AllSubDto;
import com.relations.newdemo.entity.Course;
import com.relations.newdemo.entity.Subject;
import com.relations.newdemo.repositiry.CourseRepository;

@Service
public class DtoServiceImpl implements DtoService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public List<AllSubDto> getAllCoursesAndListSubjects() {
		
		List<Course> courses=courseRepository.findAll();	
		List<AllSubDto> allSubDtos = new ArrayList<>();
		for(Course course :courses) {
			AllSubDto allSubDto =new AllSubDto();
			allSubDto.setCourseName(course.getCourseName()); //set coursename to dto coursename
			
			List<String> subjectNames=new ArrayList<>();
			for (Subject subject : course.getSubject()) {
				subjectNames.add(subject.getName());	
			}
			allSubDto.setSubjects(subjectNames);  //set subjectnames to list<subjects> inAllsubdto
			allSubDtos.add(allSubDto);
		}
		return allSubDtos;
	}

}
