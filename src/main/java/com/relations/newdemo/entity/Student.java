package com.relations.newdemo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String password;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="stud_det_id")
	private StudentDetails studentDetails;

	@ManyToMany(targetEntity=Course.class,cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
//	@JoinTable(name="student_course",
//				joinColumns= @JoinColumn(name="stud_id",referencedColumnName = "id"),
//				inverseJoinColumns=@JoinColumn(name="course_id",referencedColumnName = "id")
//	)
	@JoinColumn(name="course_id")
	List<Course> course;
}
