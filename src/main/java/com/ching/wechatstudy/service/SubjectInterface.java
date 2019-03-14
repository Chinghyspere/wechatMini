package com.ching.wechatstudy.service;

import com.ching.wechatstudy.pojo.Student;
import com.ching.wechatstudy.pojo.StudentSubject;
import com.ching.wechatstudy.pojo.Subject;

import java.util.List;


/*
 *
 *     @author Qmh
 *     @Date 2019/2/14 11:14
 *
 */
public interface SubjectInterface {
    List<Subject> querySubject (String SubjectNo);
}
