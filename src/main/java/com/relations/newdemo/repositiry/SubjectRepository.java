package com.relations.newdemo.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relations.newdemo.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {

	

}
