package com.ching.wechatstudy.controller;


import com.ching.wechatstudy.pojo.Student;
import com.ching.wechatstudy.pojo.Subject;
import com.ching.wechatstudy.serviceImp.StudentImp;
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
@RequestMapping("/api/v1/studentInfo/")
public class StudentController {

    @Resource(name = "studentImp")
    StudentImp studentImp;

    LogUtils logUtils = new LogUtils(StudentController.class);

    @RequestMapping("test")
    public Result test(@RequestParam("studentNo") String studentNo) {
        Result result = Result.success(ResultCode.SUCCESS);
        result.setData(studentImp.queryStudents(studentNo));
        return result;
    }

    //登陆操作判断参数选择相应的登陆分为教师和学生登陆
    @RequestMapping(value = "loginStudent", method = RequestMethod.POST)
    public Result login(@RequestBody Student student) {
        logUtils.info("loginTeacher 检验开始");
        Result result;
        Student t = studentImp.loginStudent(student);
        if (t == null) {
            result = Result.failure(ResultCode.DATA_IS_WRONG);
        } else {
            result = Result.success();
            result.setData(t);
        }
        return result;
    }

    @RequestMapping(value = "querySubjectStudent", method = RequestMethod.GET)
    public Result querySubjectStudent(String studentNo) {
        Result result = Result.success();
        result.setData(DateBreak.breakTime(studentImp.querySubjectStudent(studentNo)));
        return result;
    }


}
