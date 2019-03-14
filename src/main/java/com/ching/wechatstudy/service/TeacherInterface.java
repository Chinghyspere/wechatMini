package com.ching.wechatstudy.service;


import com.ching.wechatstudy.pojo.StudentSubject;
import com.ching.wechatstudy.pojo.SubjectMeta;
import com.ching.wechatstudy.pojo.Teacher;

import java.util.List;

/*
 *
 *     @author Qmh
 *     @Date 2019/2/14 11:14
 *
 */
public interface TeacherInterface {
    public Teacher LoginTeacher(Teacher teacher);
    public List<SubjectMeta> querySubjectTeacher(String teacherNo,Integer roleId);
}
