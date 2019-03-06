package com.ching.wechatstudy.service;

import com.ching.wechatstudy.pojo.DakaCount;
import com.ching.wechatstudy.pojo.Student;
import com.ching.wechatstudy.pojo.StudentSubject;

import java.util.Date;
import java.util.List;
import java.util.Map;


/*
 *
 *     @author Qmh
 *     @Date 2019/2/14 11:14
 *
 */
public interface DakaInterface {
    String daka(Integer zhi ,StudentSubject studentSubject);
    List<DakaCount> queryOne(StudentSubject studentSubject);
    Map<String,List<Student>> queryStudentDaka(String subjectNo);


}
