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
//接口
public interface StudentMapper {
	
	//插入学生
	@Insert("insert into t_student values(null,#{name},#{age})")
	public int insertStudent(Student student);
	
	//更新学生 
	@Update("update t_student set name=#{name},age=#{age} where id=#{id}")
	public int updataStudent(Student student);
	
	//删除
	@Delete("delete from t_student where id=#{id}")
	public int deleteStudent(int i); 
	
	//查询一个
	@Select("select * from t_student where id=#{id}")
	public Student findStudents(Integer id);
	
	//查询所有
	@Select("select * from t_student")
	@Results({
		//定义每个字段的映射 
		@Result(id=true,column="id",property="id"), //主键id为true，
		@Result(column="name",property="name"),
		@Result(column="age",property="age")
	})
	public List<Student> findStudent();
}
