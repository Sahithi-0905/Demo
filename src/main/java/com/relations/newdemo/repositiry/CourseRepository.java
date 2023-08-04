package com.relations.newdemo.repositiry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.relations.newdemo.entity.Course;
import com.relations.newdemo.entity.Student;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long>{
	
	@Query("SELECT c FROM Course c JOIN Student s WHERE s.id=:id")
	List<Course> findCourseByStudentsId( Long id);
}
