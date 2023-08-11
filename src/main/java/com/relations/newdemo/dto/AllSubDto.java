package com.relations.newdemo.dto;

import java.util.List;

import lombok.Data;

@Data
public class AllSubDto {
	private String courseName;
	private List<String> subjects;
}
