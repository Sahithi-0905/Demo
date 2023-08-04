package com.relations.newdemo.dto;

import java.util.List;

import com.relations.newdemo.entity.Subject;

import lombok.Data;


@Data
public class CourseDto {
    private Long id;
	private String courseName;
	private List<Subject> subject;
}
