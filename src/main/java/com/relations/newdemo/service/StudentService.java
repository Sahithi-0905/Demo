package com.relations.newdemo.service;

import java.util.List;

import com.relations.newdemo.dto.StudDto;
import com.relations.newdemo.entity.Student;
import com.relations.newdemo.entity.StudentDetails;

public interface StudentService {

	Student saveStudentAndStudentdetails(StudDto stud);

	List<Student> getAllStudents();

	Student getStudentsById(Long id);

	void deleteStudentById(Long id);

	StudentDetails getStudentsDetailsById(Long id);

	

	

	

	



	

}
