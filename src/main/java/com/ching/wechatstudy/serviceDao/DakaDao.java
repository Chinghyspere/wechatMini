package com.ching.wechatstudy.serviceDao;

import com.ching.wechatstudy.pojo.DakaCount;
import com.ching.wechatstudy.pojo.Student;
import com.ching.wechatstudy.pojo.StudentSubject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/*
 *
 *     @author Qmh
 *     @Date 2019/2/14 11:02
 *
 */

@Mapper
@Repository("dakaDao")
public interface DakaDao {
    List<DakaCount> queryOne(@Param("date") Date date, @Param("date2") Date date2, @Param("subjectNo") String subjectNo, @Param("studentNo") String studentNo);

    Integer updateStudentSubject(@Param("subjectNo") String subjectNo, @Param("studentNo") String studentNo, @Param("dakaNum") int dakaNum);

    StudentSubject queryStudentSubject(@Param("subjectNo") String subjectNo, @Param("studentNo") String studentNo);

    int updateOne(@Param("zhi")Integer zhi ,@Param("id")int id);

    int insertAll(@Param("subjectNo") String subjectNo, @Param("list") List<String> studentNos, @Param("date") Date date);

    List<String> queryAllStudentNo(String subjectNo);
    //教师查询缺勤信息


}
