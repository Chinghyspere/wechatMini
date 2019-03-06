package com.ching.wechatstudy.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.Date;

/*
 *
 *     @author Qmh
 *     @Date 2019/3/1 14:32
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DakaCount implements Serializable {
    private String subjectNo;
    private String studentNo;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date dakaDate;
    private Integer status;
    private Integer id;

}
