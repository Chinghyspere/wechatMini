package com.ching.wechatstudy.controller;


import com.ching.wechatstudy.pojo.Student;
import com.ching.wechatstudy.pojo.StudentSubject;
import com.ching.wechatstudy.serviceImp.DakaImp;
import com.ching.wechatstudy.serviceImp.StudentImp;
import com.ching.wechatstudy.utils.LogUtils;
import com.ching.wechatstudy.utils.Result;
import com.ching.wechatstudy.utils.ResultCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 *
 *     @author Qmh
 *     @Date 2019/2/14 11:16
 *
 */

@RestController
@RequestMapping("/api/v1/dakaCount/")
public class DakaCountController {

    @Resource(name = "dakaImp")
    DakaImp dakaImp;
    LogUtils logUtils = new LogUtils(DakaCountController.class);


    //打卡操作
    @RequestMapping(value = "daka",method = RequestMethod.GET)
    public Result daka(@RequestParam("studentNo")String studentNo,@RequestParam("zhi") int zhi,@RequestParam("subjectNo")String subjectNo) {
        Result result = Result.success(ResultCode.SUCCESS);
        StudentSubject studentSubject = new StudentSubject();
        studentSubject.setStudentNo(studentNo);
        studentSubject.setSubjectNo(subjectNo);
        result.setData(dakaImp.daka(zhi,studentSubject));
        return result;
    }

    //打卡操作
    @RequestMapping(value = "queryOne",method = RequestMethod.GET)
    public Result queryOne(@RequestParam("studentNo")String studentNo,@RequestParam("subjectNo")String subjectNo) {
        Result result = Result.success(ResultCode.SUCCESS);
        StudentSubject studentSubject = new StudentSubject();
        studentSubject.setStudentNo(studentNo);
        studentSubject.setSubjectNo(subjectNo);
        result.setData(dakaImp.queryOne(studentSubject));
        return result;
    }



    //打卡统计查询缺勤学生
    @RequestMapping(value = "queryStudentDaka",method = RequestMethod.GET)
    public Result queryStudentDaka(String subjectNo, String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dates = simpleDateFormat.parse(date);
        Result result = Result.success(ResultCode.SUCCESS);
        result.setData(dakaImp.queryStudentDaka(subjectNo,dates));
        return result;
    }



}
