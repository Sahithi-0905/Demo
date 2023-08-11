package com.relations.newdemo.entity;

import java.util.List;
import java.util.ArrayList;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	
	@Id
	@GeneratedValue
	private Long id;
	private String courseName;
	
	
	@ManyToMany(targetEntity=Student.class,mappedBy="course",cascade = CascadeType.ALL)//,fetch=FetchType.LAZY
	@JsonIgnore
	private List<Student> student;
	
	@OneToMany(targetEntity=Subject.class,cascade=CascadeType.ALL,fetch = FetchType.EAGER)//targetEntity=Subject.class,mappedBy="courses"
	@JoinColumn(name="courses_id",referencedColumnName="id")//,referencedColumnName="id"
	private List<Subject> subject;
}
