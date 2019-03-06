package com.ching.wechatstudy.utils;


import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/*
 *
 *     @author Qmh
 *     @Date 2019/3/2 11:20
 *
 */
public class CopyOnFields {
    static void Copy(Object o1, Object o2){
        Class c1 = o1.getClass();
        Class c2 = o2.getClass();
        if(c1 == c2){
            o1 = o2;
        }else{
         Field[] field1 =  c1.getDeclaredFields();
         List<Field> list = Arrays.asList(c2.getDeclaredFields());
         for(Field f : field1){

             }
         }
         }
    }

