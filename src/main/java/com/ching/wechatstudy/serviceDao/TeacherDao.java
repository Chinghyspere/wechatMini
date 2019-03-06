package com.ching.wechatstudy.serviceDao;

import com.ching.wechatstudy.pojo.Student;
import com.ching.wechatstudy.pojo.StudentSubject;
import com.ching.wechatstudy.pojo.SubjectMeta;
import com.ching.wechatstudy.pojo.Teacher;
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
@Repository("teacherDao")
public interface TeacherDao {
    public Teacher loginTeacher(@Param("teacherNo") String teacherNo,@Param("passWord") String passWord);
    public List<SubjectMeta> querySubjectTeacher(String teacherNo);
    public List<SubjectMeta> querySubjectFdy(String teacherNo);
}
