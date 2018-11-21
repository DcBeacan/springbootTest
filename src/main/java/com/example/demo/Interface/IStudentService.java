package com.example.demo.Interface;

import java.util.List;

import com.example.demo.pojo.StudentRepository;
import com.github.pagehelper.PageInfo;

public interface IStudentService {
    
	List<StudentRepository> findAll();
	
	void deleteById(Integer id);
	
	//Integer doStudent(StudentRepository sr);
	
    void insertIntoStudent(StudentRepository sr);
    void updateStudent(StudentRepository sr);
    
    PageInfo<StudentRepository> pageList(int pageNumber,int pageSize);
}
