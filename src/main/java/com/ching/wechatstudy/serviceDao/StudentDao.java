package com.ching.wechatstudy.serviceDao;

import com.ching.wechatstudy.pojo.Student;
import com.ching.wechatstudy.pojo.StudentSubject;
import com.ching.wechatstudy.pojo.Subject;
import com.ching.wechatstudy.pojo.SubjectMeta;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 *
 *     @author Qmh
 *     @Date 2019/2/14 11:02
 *
 */

@Mapper
@Repository("studentDao")
public interface StudentDao {
    Student queryStudents(@Param("studentNo") String studentNo);
    Student loginStudent(@Param("studentNo")String studentNo,@Param("passWord")String passWord);
    String daka(StudentSubject studentSubject);
    //查询多个缺勤学生信息
    List<Student> queryAllStudents(List<String> studentNo);
    //查询学生课表基础信息
    List<SubjectMeta> querySubjectStudent(String studentNo);
}
