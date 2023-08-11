package com.relations.newdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relations.newdemo.dto.AllSubDto;
import com.relations.newdemo.dto.CourseDto;
import com.relations.newdemo.entity.Course;
import com.relations.newdemo.entity.Student;
import com.relations.newdemo.entity.Subject;
import com.relations.newdemo.repositiry.CourseRepository;
import com.relations.newdemo.repositiry.StudentRepository;
import com.relations.newdemo.repositiry.SubjectRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
	@Autowired
	private StudentRepository studentRepository;
	//save Course
	@Override
	public Course saveCourse(Course course) {
	
		return courseRepository.save(course);
	}
	
	//get all courses
	@Override
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
		
	}
	@Override
	public void deleteCourse(Long id) {
		courseRepository.deleteById(id);
		
	}
//	@Override
//	public Course updateCourseById(Coursedto coursedto,Long id) {
//		Course c=courseRepository.findById(id).get();
//		//Subject s=subjectRepository.findById(id).get();
//		c.setCourseName(course.getCourseName());
//		
//		//s.setSubject(course.getSubject());
//		return courseRepository.save(c);
//	}
	@Override
	public Course updateCourseById(CourseDto coursedto, Long id) {
//		Course c=courseRepository.findById(id).get();
//		if(coursedto.getCourseName() != null) {
//			c.setCourseName(coursedto.getCourseName());
//		}
		
		return null;
	}
	
	
	@Override
	public Course saveCourseDto(CourseDto courseDto) {
		Course cDto= new Course();
		cDto.setCourseName(courseDto.getCourseName());
		
		List<Subject> ls=new ArrayList<>();
		courseDto.getSubject().forEach(s->{
			Subject ss=new Subject();
			ss.setName(s.getName());
			ls.add(ss);
		});
		cDto.setSubject(ls);
		return courseRepository.save(cDto);
	}

	@Override
	public List<String> getAllStudentsInCourse(Long id) {
//		Course co=courseRepository.findById(id).orElse(null);
//		if (co!=null) {
//			return co.getStudent();
//		}
		return studentRepository.findStudentsByCourseId(id);
	}

	@Override
	public List<Course> getAllCoursesByStudentId(Long id) {
	
		return courseRepository.findCourseByStudentsId(id);
	}
	
	
}

