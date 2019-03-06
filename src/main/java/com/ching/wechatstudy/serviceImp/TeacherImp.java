package com.ching.wechatstudy.serviceImp;

import com.ching.wechatstudy.pojo.*;
import com.ching.wechatstudy.service.StudentInterface;
import com.ching.wechatstudy.service.TeacherInterface;
import com.ching.wechatstudy.serviceDao.StudentDao;
import com.ching.wechatstudy.serviceDao.TeacherDao;
import com.ching.wechatstudy.utils.LogUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/*
 *
 *     @author Qmh
 *     @Date 2019/2/14 11:13
 *
 */

@Service("teacherImp")
@Transactional
public class TeacherImp implements TeacherInterface {

    @Resource
    private TeacherDao teacherDao;
    @Resource
    private StudentDao studentDao;

    @Override
    public Teacher LoginTeacher(Teacher teacher) {
        return teacherDao.loginTeacher(teacher.getTeacherNo(),teacher.getPassWord());
    }

    @Override
    public List<SubjectMeta> querySubjectTeacher(String teacherNo,Integer roleId) {
        if(roleId ==1)
            return teacherDao.querySubjectTeacher(teacherNo);
        else {
            return teacherDao.querySubjectFdy(teacherNo);
        }
    }
}
