package com.ching.wechatstudy.controller;


import com.ching.wechatstudy.pojo.Student;
import com.ching.wechatstudy.serviceImp.StudentImp;
import com.ching.wechatstudy.serviceImp.SubjectImp;
import com.ching.wechatstudy.utils.LogUtils;
import com.ching.wechatstudy.utils.Result;
import com.ching.wechatstudy.utils.ResultCode;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/*
 *
 *     @author Qmh
 *     @Date 2019/2/14 11:16
 *
 */

@RestController
@RequestMapping("/api/v1/subject/")
public class SubjectController {
    @Resource(name = "subjectImp")
    SubjectImp subjectImp;

    LogUtils logUtils = new LogUtils(SubjectController.class);

    @RequestMapping(value = "querySubject",method = RequestMethod.GET)
    public Result querySubject(String subjectNo) {
        Result result = Result.success(ResultCode.SUCCESS);
        result.setData(subjectImp.querySubject(subjectNo));
        return result;
    }



}
