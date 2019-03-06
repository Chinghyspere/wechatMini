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
 *     @Date 2019/3/2 10:51
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDate extends SubjectMeta {
    @JsonFormat(pattern = "HH:mm:ss",timezone = "GMT+8")
    private Date startTime;
    @JsonFormat(pattern = "HH:mm:ss",timezone = "GMT+8")
    private Date endTime;
}
