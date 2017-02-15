package com.java;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.java.mappers.StudentMapper;
import com.java.model.Student;
import com.java.util.SqlSessionFactoryUtil;


//测试数据库连接
public class StudentTest {
	
	private static Logger logger = Logger.getLogger(StudentTest.class);
	private SqlSession sqlSession = null;//打开数据库连接
	private StudentMapper studentMapper = null; //映射器
	@Before   //测试方法执行之前调用
	public void setUp() throws Exception {
		sqlSession = SqlSessionFactoryUtil.openSession();
		studentMapper = sqlSession.getMapper(StudentMapper.class);
	}

	@After    //测试方法执行之后调用
	public void tearDown() throws Exception {
		sqlSession.close();
	}

	
	/*@Test      //插入学生
	public void tesInsertStudent(){
		logger.info("添加学生");
		Student student = new Student("qiq",11);
		studentMapper.insertStudent(student);
		sqlSession.commit();
	}*/
	
	/*@Test      //更新学生
	public void tesUpdataStudent(){
		logger.info("添加学生");
		Student student = new Student(7,"hhhhh",11);
		studentMapper.updataStudent(student);
		sqlSession.commit();
	}*/
	
	/*@Test      //删除学生
	public void tesUpdataStudent(){
		logger.info("添加学生");
		studentMapper.deleteStudent(7);
		sqlSession.commit();
	}*/
	
	/*@Test      //查找学生
	public void tesUpdataStudent(){
		logger.info("查找学生");
		Student student = studentMapper.findStudents(8);
		System.out.println(student);
	}*/
	
	@Test      //查找所有学生
	public void tesFindAllStudent(){
		logger.info("查找学生");
		List<Student> studentList = studentMapper.findStudent();
		for(Student student:studentList){
			System.out.println(student);
		}
		
	}
}
