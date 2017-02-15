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


//�������ݿ�����
public class StudentTest {
	
	private static Logger logger = Logger.getLogger(StudentTest.class);
	private SqlSession sqlSession = null;//�����ݿ�����
	private StudentMapper studentMapper = null; //ӳ����
	@Before   //���Է���ִ��֮ǰ����
	public void setUp() throws Exception {
		sqlSession = SqlSessionFactoryUtil.openSession();
		studentMapper = sqlSession.getMapper(StudentMapper.class);
	}

	@After    //���Է���ִ��֮�����
	public void tearDown() throws Exception {
		sqlSession.close();
	}

	
	/*@Test      //����ѧ��
	public void tesInsertStudent(){
		logger.info("���ѧ��");
		Student student = new Student("qiq",11);
		studentMapper.insertStudent(student);
		sqlSession.commit();
	}*/
	
	/*@Test      //����ѧ��
	public void tesUpdataStudent(){
		logger.info("���ѧ��");
		Student student = new Student(7,"hhhhh",11);
		studentMapper.updataStudent(student);
		sqlSession.commit();
	}*/
	
	/*@Test      //ɾ��ѧ��
	public void tesUpdataStudent(){
		logger.info("���ѧ��");
		studentMapper.deleteStudent(7);
		sqlSession.commit();
	}*/
	
	/*@Test      //����ѧ��
	public void tesUpdataStudent(){
		logger.info("����ѧ��");
		Student student = studentMapper.findStudents(8);
		System.out.println(student);
	}*/
	
	@Test      //��������ѧ��
	public void tesFindAllStudent(){
		logger.info("����ѧ��");
		List<Student> studentList = studentMapper.findStudent();
		for(Student student:studentList){
			System.out.println(student);
		}
		
	}
}
