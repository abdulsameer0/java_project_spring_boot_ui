package com.sms.repository;

import org.springframework.data.repository.CrudRepository;

import com.sms.entity.Student;

public interface StudentRepository  extends CrudRepository<Student, Long>{

}
