package com.relations.newdemo.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relations.newdemo.entity.StudentAddress;

@Repository
public interface StudentAddressRepository extends JpaRepository<StudentAddress,Long>{
	
}
