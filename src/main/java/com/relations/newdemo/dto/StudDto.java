package com.relations.newdemo.dto;

import java.util.List;

import lombok.Data;

@Data
public class StudDto {
	private String name;
	private String password;
	private Long phoneNumber;
	private List<Long> courseId;
}
