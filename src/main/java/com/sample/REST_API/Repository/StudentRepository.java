package com.sample.REST_API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.REST_API.Model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{
		
	}
