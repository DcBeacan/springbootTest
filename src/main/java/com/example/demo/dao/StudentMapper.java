package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.pojo.StudentRepository;
@Repository
public interface StudentMapper {
    /**
     * 查询所有
     * @return
     */
	List<StudentRepository> findAll();
	/**
     * 删除根据id
     * @return
     */
	void deleteById(Integer i);
	
	/**
     * 根据id查询一个
     * @return
     */
	StudentRepository findById(Integer i);
	
	/**
     * 更新表
     * @return
     */
	void updateStudent(StudentRepository sr);
	
	/**
     * 增加数据
     * @return
     */
	void insertInToStudent(StudentRepository sr);
}
