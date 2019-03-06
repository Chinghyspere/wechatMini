package com.ching.wechatstudy.utils;

/*
 *
 *     @author Qmh
 *     @Date 2019/3/1 22:59
 *
 */

import com.ching.wechatstudy.pojo.Subject;
import com.ching.wechatstudy.pojo.SubjectDate;
import com.ching.wechatstudy.pojo.SubjectMeta;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DateBreak {
    public static List<SubjectDate> breakTime(List<SubjectMeta> metaList) {
        List<SubjectDate> list = new ArrayList<>();
        metaList.forEach(ml -> {
            String weekDay = ml.getWeekDay();
            List<String[]> z = parseDay(weekDay);
            z.forEach(zhi -> {
                SubjectDate subjectDate = new SubjectDate();
//                CopyOnFields(subjectDate,ml);
                //进行相关赋值复制操作。
                subjectDate.setAddr(ml.getAddr());
                subjectDate.setDakaNum(ml.getDakaNum());
                subjectDate.setName(ml.getName());
                subjectDate.setNeedNum(ml.getNeedNum());
                subjectDate.setStudentNo(ml.getStudentNo());
                subjectDate.setSubjectName(ml.getSubjectName());
                subjectDate.setSubjectNo(ml.getSubjectNo());
                subjectDate.setTeacherNo(ml.getTeacherNo());

                subjectDate.setId(Integer.parseInt(zhi[0]));
                subjectDate.setWeekDay(zhi[1]);
                subjectDate.setStartTime(toTime(zhi[2]));
                subjectDate.setEndTime(toTime(zhi[3]));
                list.add(subjectDate);
            });
        });
        list.sort(((o1, o2) -> {
            return o1.getId()-o2.getId();
        }));
        return list;


    }



    private static Date toTime(String s)  {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
            return null;
    }

    private static List<String[]> parseDay(String weekDay) {
        List<String[]> list =new ArrayList<>();
        Arrays.asList(weekDay.split(",")).forEach(s -> {
           String[] ss = s.split("%");
           list.add(ss);
        });
        return list;
    }
}
