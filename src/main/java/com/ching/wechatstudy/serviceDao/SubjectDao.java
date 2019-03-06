package com.ching.wechatstudy.serviceDao;

import com.ching.wechatstudy.pojo.Student;
import com.ching.wechatstudy.pojo.Subject;
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
@Repository("subjectDao")
public interface SubjectDao {
    List<Subject> querySubject (String subjectNo);
}
