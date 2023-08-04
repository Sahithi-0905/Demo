package com.relations.newdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relations.newdemo.entity.Subject;
import com.relations.newdemo.repositiry.SubjectRepository;

@RestController
@RequestMapping("/sub")
public class SubjectController {

	@Autowired
	private SubjectRepository subjectRepository;
	
	@PostMapping("/save")
	public Subject savesubjects(@RequestBody Subject subject ) {
		return subjectRepository.save(subject);
	}
	
	@GetMapping("/findall")
	public List<Subject> getAllSubjects(){
		return subjectRepository.findAll();
	}
	
}
