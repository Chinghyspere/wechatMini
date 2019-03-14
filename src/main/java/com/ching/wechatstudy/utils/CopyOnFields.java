package com.ching.wechatstudy.utils;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;


/*
 *
 *     @author Qmh
 *     @Date 2019/3/2 11:20
 *
 */
public class CopyOnFields {

//
//               进行父类和子类属性的传递
//               static void Copy(Object o1, Object o2){
//                subjectDate.setAddr(ml.getAddr());
//                subjectDate.setDakaNum(ml.getDakaNum());
//                subjectDate.setName(ml.getName());
//                subjectDate.setNeedNum(ml.getNeedNum());
//                subjectDate.setStudentNo(ml.getStudentNo());
//                subjectDate.setSubjectName(ml.getSubjectName());
//                subjectDate.setSubjectNo(ml.getSubjectNo());
//                subjectDate.setTeacherNo(ml.getTeacherNo());
//                }

    static <T> void Copy(T o1, T o2) {

        Class<?> fclass = o1.getClass();
        Field[] fields = fclass.getDeclaredFields();
        Arrays.asList(fields).forEach(field -> {
            try {
                //由于无法访问父类private属性所以采用代理使用get方法来访问属性的值
                Method method = fclass.getDeclaredMethod("get" + UpLoad(field.getName()));
                Object obj = method.invoke(o1);
                //得到父类方法的相关字段的getProperty的值
                field.setAccessible(true);
                //把值放入子类中去
                field.set(o2, obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static String UpLoad(String name) {
        String upName = name.substring(0, 1);
        return upName.toUpperCase()+name.substring(1, name.length());
    }

}

