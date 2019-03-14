package com.ching.wechatstudy.serviceImp;

import com.ching.wechatstudy.pojo.Student;
import com.ching.wechatstudy.pojo.StudentSubject;
import com.ching.wechatstudy.pojo.SubjectMeta;
import com.ching.wechatstudy.service.StudentInterface;
import com.ching.wechatstudy.serviceDao.StudentDao;
import com.ching.wechatstudy.utils.LogUtils;
import com.ching.wechatstudy.utils.Result;
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

@Service("studentImp")
@Transactional
public class StudentImp implements StudentInterface {
    @Resource(name = "studentDao")
    StudentDao studentDao;

    LogUtils logUtils = new LogUtils(StudentImp.class);

    @Override
    public Student queryStudents(String studentNo) {
        logUtils.info("queryStudents");
        return studentDao.queryStudents(studentNo);
    }

    @Override
    public Student loginStudent(Student student) {
        logUtils.info("LoginTest");
        return studentDao.loginStudent(student.getStudentNo(), student.getPassWord());
    }

    @Override
    public List<SubjectMeta> querySubjectStudent(String studentNo) {
        return studentDao.querySubjectStudent(studentNo);
    }


}
