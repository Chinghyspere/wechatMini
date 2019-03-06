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

    //打卡统计
    @RequestMapping(value = "queryStudentDaka",method = RequestMethod.GET)
    public Result queryStudentDaka(String subjectNo) {
        Result result = Result.success(ResultCode.SUCCESS);
        result.setData(dakaImp.queryStudentDaka(subjectNo));
        return result;
    }



}
