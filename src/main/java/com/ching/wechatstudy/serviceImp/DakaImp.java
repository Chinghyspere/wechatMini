package com.ching.wechatstudy.serviceImp;

import com.ching.wechatstudy.pojo.DakaCount;
import com.ching.wechatstudy.pojo.Student;
import com.ching.wechatstudy.pojo.StudentSubject;
import com.ching.wechatstudy.service.DakaInterface;
import com.ching.wechatstudy.serviceDao.DakaDao;
import com.ching.wechatstudy.serviceDao.StudentDao;
import com.ching.wechatstudy.serviceDao.SubjectDao;
import com.ching.wechatstudy.serviceDao.qjDao;
import com.ching.wechatstudy.utils.LogUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/*
 *
 *     @author Qmh
 *     @Date 2019/3/1 14:38
 *
 */


@Service("dakaImp")
@Transactional
public class DakaImp implements DakaInterface {

    @Resource(name = "dakaDao")
    DakaDao dakaDao;

    @Resource(name = "studentDao")
    StudentDao studentDao;

    @Resource(name = "qjDao")
    qjDao qjDao;

    @Resource(name="subjectDao")
    SubjectDao subjectDao;

    LogUtils logUtils = new LogUtils(DakaImp.class);



    private Object isNull(Object object) {
        if (ObjectUtils.isEmpty(object)) {
            return null;
        } else {
            return object;
        }
    }
    private List<Calendar> getNowDate() {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.HOUR_OF_DAY, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.MINUTE, 0);
        calendar2.set(Calendar.HOUR_OF_DAY, 0);
        calendar2.set(Calendar.SECOND, 0);
        calendar2.set(Calendar.DAY_OF_MONTH, calendar2.get(Calendar.DAY_OF_MONTH) + 1);
        List<Calendar> list = new ArrayList<>();
        list.add(calendar1);
        list.add(calendar2);
        return list;
    }



    //核心操作
    //进行的操作是先得到今天打卡科目和学生信息，之后获取当天日期
    //然后根据日期查询数据库是否存在这条记录，若不存在，则进行打卡插入所有学生的记录，并把自己这个学号的记录status设为1其余设为0
    //同时修改学生课程关联表设为+1
    //若存在则看是否为1为一返回已经打过卡了，为0则改为1返回打卡成功
    //请假流程先查看是否有记录若有则ok若无则重复上面的插入所有的操作。并请假相关日期。
    //请假需要日期，请假哪几门课！！！！
    @Override
    public String daka(Integer zhi ,StudentSubject studentSubject) {
        logUtils.info("daka is begin !");
        List<DakaCount> dakaCountList = (List<DakaCount>) isNull(queryOne(studentSubject));
        String subjectNo = studentSubject.getSubjectNo();
        String studentNo = studentSubject.getStudentNo();
        if (dakaCountList == null) {
            //插入数据
            List<String> list = dakaDao.queryAllStudentNo(subjectNo);
            dakaDao.insertAll(subjectNo, list, new Date());
            daka(zhi,studentSubject);
            return "打卡完成!";
        } else if (dakaCountList.get(0).getStatus() != 0) {
            //alert
            return "已经打过卡了！";
        } else if (dakaCountList.get(0).getStatus() == 0) {
            //update
            dakaDao.updateOne(zhi,dakaCountList.get(0).getId());
            int dakaNum =  dakaDao.queryStudentSubject(subjectNo,studentNo).getDakaNum()+1;
            dakaDao.updateStudentSubject(subjectNo,studentNo,dakaNum);
            return "打卡完成!";
        }
        return "打卡失败";
    }

    //查询打卡记录
    @Override
    public List<DakaCount> queryOne(StudentSubject studentSubject) {
        //根据当前日期查询相关信息
        List<Calendar> dates = getNowDate();
        return dakaDao.queryOne(dates.get(0).getTime(),dates.get(1).getTime(),studentSubject.getSubjectNo(), studentSubject.getStudentNo());
    }

    //查询未打卡的学生
    @Override
    public Map<String,List<Student>> queryStudentDaka(String subjectNo,Date date) {
        List<Calendar> dates = getNowDate();
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = qjDao.queryQjStudentNo(date);
        Map<String,List<Student>> map = new HashMap<>();
        List<DakaCount> students= dakaDao.queryOne(dates.get(0).getTime(),dates.get(1).getTime(),subjectNo,"");
        //若无人打卡则全为缺勤
        if (students.size() == 0) {
            list.addAll(studentDao.queryAllStudent(subjectNo));
        } else {
            students.forEach(s -> {
                if (s.getStatus() == 0 && !list3.contains(s.getStudentNo())) {
                    list.add(s.getStudentNo());
                } else if (s.getStatus() == 2) {
                    list2.add(s.getStudentNo());
                }
            });
        }
        //移除缺勤和请假相同的学生
        list3.forEach(ll->{
            if(list.contains(ll)){
                list.remove(ll);
            }
        });

        List<Student> listStudents = null;
        List<Student> listStudents2 = null;
        List<Student> listStudents3 = null;
        if(isNull(list)!=null){
            listStudents = studentDao.queryAllStudents(list);
        }
        if(isNull(list2)!=null){
            listStudents2 = studentDao.queryAllStudents(list2);
        }
        if(isNull(list3)!=null){
            listStudents3 = studentDao.queryAllStudents(list3);
        }
        map.put("qq",listStudents);
        map.put("cd",listStudents2);
        map.put("qj",listStudents3);
        return map;
    }


}
