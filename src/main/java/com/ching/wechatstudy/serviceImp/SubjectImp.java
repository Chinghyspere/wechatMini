package com.ching.wechatstudy.serviceImp;

/*
 *
 *     @author Qmh
 *     @Date 2019/3/1 14:38
 *
 */

import com.ching.wechatstudy.pojo.Subject;
import com.ching.wechatstudy.service.SubjectInterface;
import com.ching.wechatstudy.serviceDao.SubjectDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("subjectImp")
@Transactional
public class SubjectImp implements SubjectInterface {

    @Resource
    private SubjectDao subjectDao;


    @Override
    public List<Subject> querySubject(String subjectNo) {
        return subjectDao.querySubject(subjectNo);
    }
}
