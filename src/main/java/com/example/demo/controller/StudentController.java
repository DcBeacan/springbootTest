package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.example.demo.Interface.IStudentService;
import com.example.demo.pojo.StudentRepository;
import com.github.pagehelper.PageInfo;

@RestController
public class StudentController {
	

	
	@Autowired
	  //@Qualifier("IStudentService")
	private IStudentService iss;
	
	@RequestMapping("/list")
	public String findAll() {
		   List<StudentRepository> students = iss.findAll();
		
		return JSON.toJSONString(students);
		
		
	}

	@RequestMapping("/delete/{id}")
	public String deleteById(@PathVariable Integer id) {
		  iss.deleteById(id);
		
		return JSON.toJSONString(iss.findAll());
		
	}

	@RequestMapping("/insert")
	public String insert(StudentRepository sr) {
		  iss.insertIntoStudent(sr);
		
		return  JSON.toJSONString(iss.findAll());
		
	}

	@RequestMapping("/update")
	public String update(StudentRepository sr) {
		   iss.updateStudent(sr);
		
		return JSON.toJSONString(iss.findAll());
		
	}
	@RequestMapping("/pageList")
	public String pageList(@RequestParam (value="pageNumber",defaultValue="1") Integer pageNumber ) {
		
		PageInfo<StudentRepository> page = iss.pageList(pageNumber, 5);
		return JSON.toJSONString(page.getList());
	}
	
	
}
