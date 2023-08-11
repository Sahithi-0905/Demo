package com.relations.newdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relations.newdemo.dto.StudDto;
import com.relations.newdemo.dto.StudentDetailsDto;
import com.relations.newdemo.entity.Course;
import com.relations.newdemo.entity.Student;
import com.relations.newdemo.entity.StudentDetails;
import com.relations.newdemo.repositiry.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudentAndStudentdetails(StudDto stud) {
		Student s = new Student();
		s.setName(stud.getName());
		s.setPassword(stud.getPassword());
		
		StudentDetails sd= new StudentDetails();
		sd.setPhoneNumber(stud.getPhoneNumber());
		s.setStudentDetails(sd);
		System.out.println("======");
		List<Course> cl=new ArrayList<>();
		
		stud.getCourseId().forEach(cid->{
			cl.add(	Course.builder().id(cid).build());

		});
		s.setCourse(cl);
		System.out.println("======");
		//s.St//(stud.getPhoneNumber());
		//s.setCourse(stud.getId());
		return studentRepository.save(s);
	}

	@Override
	public List<Student> getAllStudents() {
//		System.out.println("=====================");
//		 studentRepository.findAll();
		 return studentRepository.findAll();
	}

	@Override
	public Student getStudentsById(Long id) {
		return studentRepository.findById(id).get();         
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
		
	}

	@Override
	public StudentDetails getStudentsDetailsById(Long id) {
		Student student=studentRepository.findById(id).orElse(null);
		if (student !=null) {
			return student.getStudentDetails();
		}
		
		return null;
	}

	

	



}
