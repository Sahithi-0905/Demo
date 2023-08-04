package com.relations.newdemo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class StudentAddress {
	
	@Id
	@GeneratedValue
	private Long id;
	private String address;
	private Long pinCode;
	
	@ManyToOne
	@JoinColumn(name="stud_id")
	private Student student;
}
//CourseRepository