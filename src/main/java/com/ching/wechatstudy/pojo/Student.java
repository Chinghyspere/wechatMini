package com.ching.wechatstudy.pojo;

/*
 *
 *     @author Qmh
 *     @Date 2019/2/7 15:51
 *
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student  implements Serializable {
    private String studentNo;
    private String name;
    private String passWord;
    private String teacherNo;
    private String classbj;
}
