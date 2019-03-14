package com.ching.wechatstudy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*
 *
 *     @author Qmh
 *     @Date 2019/3/1 14:30
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher implements Serializable {
        private String role;
        private String name;
        private String passWord;
        private String teacherNo;
}
