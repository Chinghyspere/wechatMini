package com.ching.wechatstudy.serviceDao;

/*
 *
 *     @author Qmh
 *     @Date 2019/3/6 9:40
 *
 */

import com.ching.wechatstudy.pojo.qjData;
import com.ching.wechatstudy.pojo.qjMeta;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository("qjDao")
public interface qjDao {
    public int addOneQjMeta(qjMeta qjMeta);


    public int updateOneQjMeta(qjMeta qjMeta);

    //教师辅导员点击课程查看学生请假名字
    public List<String> queryQjStudentNo(@Param("date") Date date);

    //处理请假业务根据ID
    public int updateQj(List<Integer> list);

    //处理请假业务根据ID
    public int updateOne(@Param("id") Integer id,@Param("zhi")Integer zhi);

    //学生辅导员,辅导员查看请假请求
    public List<qjData> queryQjData(@Param("studentNo") String studentNo,@Param("fdyNo")String fdyNo);

    //辅导员查看详细请假请求
    public qjMeta queryQjMeta(Integer id);


}
