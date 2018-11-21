package com.example.demo.serivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Interface.IStudentService;
import com.example.demo.dao.StudentMapper;
import com.example.demo.pojo.StudentRepository;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service//("IStudentService")
public class StudentServiceIml implements IStudentService {
     
	@Autowired
	private StudentMapper studentMapper;
	
	@Override
	public List<StudentRepository> findAll() {
		
		return studentMapper.findAll();
	}

	@Transactional
	@Override
	public void deleteById(Integer id) {
		studentMapper.deleteById(id);

	}
  /*   @Transactional
	@Override
	public Integer doStudent(StudentRepository sr) {
		if(null!=sr.getId()) {
			StudentRepository sr1 = new StudentRepository();
			sr1.setAge(sr.getAge());
			sr1.setName(sr.getName());
			studentMapper.updateStudent(sr1);
			return sr.getId();
		}else {
			studentMapper.insertInToStudent(sr);
		}
		return sr.getId();
	}
*/
	 @Transactional
	@Override
	public void insertIntoStudent(StudentRepository sr) {
		 StudentRepository student= new StudentRepository();
		   student.setAge(sr.getAge());
		   student.setName(sr.getName());
		 studentMapper.insertInToStudent(student);
		
	}
	 @Transactional
	@Override
	public void updateStudent(StudentRepository sr) {
		 StudentRepository student = studentMapper.findById(sr.getId());
		 student.setAge(sr.getAge());
		 student.setName(sr.getName());
		studentMapper.updateStudent(student);
		
	}

	@Override
	public PageInfo<StudentRepository> pageList(int pageNumber, int pageSize) {
		 PageHelper.startPage(pageNumber,pageSize);
		 System.out.println(pageSize);
		List<StudentRepository> f = studentMapper.findAll();
		PageInfo<StudentRepository> page = new PageInfo<>(f);
		return  page;
	}
	
	
}
