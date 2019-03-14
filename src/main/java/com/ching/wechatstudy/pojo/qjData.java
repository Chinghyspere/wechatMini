package com.ching.wechatstudy.pojo;

/*
 *
 *     @author Qmh
 *     @Date 2019/3/6 11:42
 *
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class qjData implements Serializable {
    private Integer id;
    private String name;
    private String studentNo;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date qjTime;
    private String classbj;
    private Integer status;
}
