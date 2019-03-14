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
public class Subject  implements Serializable {
    private String subjectNo;
    private String subjectName;
    private String jingDu;
    private String weiDu;
    private String weekDay;
    private String addr;
}
