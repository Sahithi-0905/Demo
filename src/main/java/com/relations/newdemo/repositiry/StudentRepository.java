package com.relations.newdemo.repositiry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.relations.newdemo.dto.StudentDetailsDto;
import com.relations.newdemo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{

//	@Query("")
//	public StudentDetailsDto getStudentDetailsById();
//select s.name from student s JOIN student_course sc ON s.id=sc.student_id where sc.course_id=:id
	@Query(value = "SELECT s.name FROM Student s JOIN student_course sc ON s.id=sc.student_id WHERE sc.course_id=?1",nativeQuery = true)
	List<String> findStudentsByCourseId( Long id);
	
//	@Query("SELECT c.name FROM Course c JOIN c.student WHERE s.id=?1")
//	List<String> findCourseByStudentsId( Long id);
}
