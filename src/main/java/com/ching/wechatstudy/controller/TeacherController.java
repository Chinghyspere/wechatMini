package com.ching.wechatstudy.controller;


import com.ching.wechatstudy.pojo.Student;
import com.ching.wechatstudy.pojo.Teacher;
import com.ching.wechatstudy.serviceImp.StudentImp;
import com.ching.wechatstudy.serviceImp.TeacherImp;
import com.ching.wechatstudy.utils.DateBreak;
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
@RequestMapping("/api/v1/teacher/")
public class TeacherController {
    @Resource(name = "teacherImp")
    TeacherImp teacherImp;

    LogUtils logUtils = new LogUtils(TeacherController.class);

    //登陆操作判断参数选择相应的登陆分为教师和学生登陆
    @RequestMapping(value = "loginTeacher", method = RequestMethod.POST)
    public Result loginTeacher(@RequestBody Teacher teacher) {
        logUtils.info("loginTeacher 检验开始");
        Result result;
        Teacher t = teacherImp.LoginTeacher(teacher);
        if (t == null) {
            result = Result.failure(ResultCode.DATA_IS_WRONG);
        } else {
            result = Result.success();
            result.setData(t);
        }
        return result;
    }

    @RequestMapping(value = "querySubjectTeacher", method = RequestMethod.GET)
    public Result querySubjectTeacher(String teacherNo,Integer roleId) {
        Result result = Result.success();
        result.setData(DateBreak.breakTime(teacherImp.querySubjectTeacher(teacherNo,roleId)));
        return result;
    }


}
