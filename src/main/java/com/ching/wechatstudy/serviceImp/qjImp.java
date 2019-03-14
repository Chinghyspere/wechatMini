package com.ching.wechatstudy.serviceImp;

/*
 *
 *     @author Qmh
 *     @Date 2019/3/6 9:40
 *
 */


import com.ching.wechatstudy.pojo.qjData;
import com.ching.wechatstudy.pojo.qjMeta;
import com.ching.wechatstudy.service.qjInteface;
import com.ching.wechatstudy.serviceDao.qjDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("qjImp")
@Transactional
public class qjImp implements qjInteface {

    @Resource(name = "qjDao")
    qjDao qjDao;


    @Override
    public int addOneQjMeta(qjMeta qjMeta) {
        return qjDao.addOneQjMeta(qjMeta);
    }

    @Override
    public int updateOneQjMeta(qjMeta qjMeta) {
        return qjDao.updateOneQjMeta(qjMeta);
    }


    @Override
    public List<qjData> queryQjData(String studentNo,String fdyNo) {
        return qjDao.queryQjData(studentNo,fdyNo);
    }

    @Override
    public qjMeta queryQjMeta(Integer id) {
        return qjDao.queryQjMeta(id);
    }

    @Override
    public int updateQj(List<Integer> list) {
        return qjDao.updateQj(list);
    }
    @Override
    public int updateOne(Integer id,Integer zhi) {
        return qjDao.updateOne(id, zhi);
    }
    @Override
    public List<String> queryQjStudentNo(Date date) { return qjDao.queryQjStudentNo(date); }


}
