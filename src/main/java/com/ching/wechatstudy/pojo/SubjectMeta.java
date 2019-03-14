package com.ching.wechatstudy.pojo;

/*
 *
 *     @author Qmh
 *     @Date 2019/3/2 10:34
 *
 */


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectMeta implements Serializable {
    private Integer id;
    private String studentNo;
    private String subjectNo;
    private Integer needNum;
    private Integer dakaNum;
    private String teacherNo;
    private String subjectName;
    private String weekDay;
    private String addr;
    private String name;


}
