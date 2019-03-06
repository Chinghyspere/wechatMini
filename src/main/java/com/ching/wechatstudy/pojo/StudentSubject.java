package com.ching.wechatstudy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*
 *
 *     @author Qmh
 *     @Date 2019/3/1 14:34
 *
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentSubject implements Serializable {
    private String studentNo;
    private String subjectNo;
    private Integer needNum;
    private Integer dakaNum;
    private String teacherNo;

}
