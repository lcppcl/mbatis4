package com.java.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import com.java.model.Student;
//�ӿ�
public interface StudentMapper {
	
	//����ѧ��
	@Insert("insert into t_student values(null,#{name},#{age})")
	public int insertStudent(Student student);
	
	//����ѧ�� 
	@Update("update t_student set name=#{name},age=#{age} where id=#{id}")
	public int updataStudent(Student student);
	
	//ɾ��
	@Delete("delete from t_student where id=#{id}")
	public int deleteStudent(int i); 
	
	//��ѯһ��
	@Select("select * from t_student where id=#{id}")
	public Student findStudents(Integer id);
	
	//��ѯ����
	@Select("select * from t_student")
	@Results({
		//����ÿ���ֶε�ӳ�� 
		@Result(id=true,column="id",property="id"), //����idΪtrue��
		@Result(column="name",property="name"),
		@Result(column="age",property="age")
	})
	public List<Student> findStudent();
}
