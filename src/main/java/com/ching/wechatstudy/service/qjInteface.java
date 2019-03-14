package com.ching.wechatstudy.service;

/*
 *
 *     @author Qmh
 *     @Date 2019/3/6 9:38
 *
 */


import com.ching.wechatstudy.pojo.qjData;
import com.ching.wechatstudy.pojo.qjMeta;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface qjInteface {
    public int addOneQjMeta(qjMeta qjMeta);
    public int updateOneQjMeta(qjMeta qjMeta);
    public List<qjData> queryQjData(String studentNo,String fdyNo);
    public qjMeta queryQjMeta(Integer id);
    public int updateQj(List<Integer> list);
    public List<String> queryQjStudentNo(  Date date);
    public int updateOne(Integer id,Integer zhi);
}
