package com.ching.wechatstudy.controller;

/*
 *
 *     @author Qmh
 *     @Date 2019/3/6 9:42
 *
 */


import com.alibaba.fastjson.JSONObject;
import com.ching.wechatstudy.pojo.qjMeta;
import com.ching.wechatstudy.serviceImp.qjImp;
import com.ching.wechatstudy.utils.LogUtils;
import com.ching.wechatstudy.utils.Result;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/qj/")
public class qjController {

    @Resource(name = "qjImp")
    qjImp qjImp;
    LogUtils logUtils = new LogUtils(qjController.class);

    @RequestMapping(value = "addOne", method = RequestMethod.POST)
    public Result addOne(@RequestBody qjMeta qjMeta) {
        qjMeta.setQjTime(new Date());
        qjMeta.setStatus("0");
        Result result = Result.success(qjImp.addOneQjMeta(qjMeta));
        return result;
    }

    @RequestMapping(value = "updateOneQjMeta", method = RequestMethod.POST)
    public Result updateOneQjMeta(@RequestBody qjMeta qjMeta) {
        qjMeta.setQjTime(new Date());
        qjMeta.setStatus("0");
        Result result = Result.success(qjImp.updateOneQjMeta(qjMeta));
        return result;
    }

    @RequestMapping(value = "queryQjMeta", method = RequestMethod.GET)
    public Result queryQjMeta(Integer id) {
        Result result = Result.success(qjImp.queryQjMeta(id));
        return result;
    }

    @RequestMapping(value = "updateQj", method = RequestMethod.POST)
    public Result updateQj(@RequestBody String list) {
        JSONObject jsonObject = JSONObject.parseObject(list);
        List<Integer>lists = jsonObject.getJSONArray("list").toJavaList(Integer.class);
        Result result = Result.success(qjImp.updateQj(lists));
        return result;
    }

    @RequestMapping(value = "updateOne", method = RequestMethod.POST)
    public Result updateOne(@RequestBody String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        Integer id =jsonObject.getInteger("id");
        Integer zhi =jsonObject.getInteger("zhi");
        Result result = Result.success(qjImp.updateOne(id,zhi));
        return result;
    }

    @RequestMapping(value = "queryQjData", method = RequestMethod.GET)
    public Result queryQjDate(String studentNo,String fdyNo) {
        Result result = Result.success(qjImp.queryQjData(studentNo.equals("")?null:studentNo,fdyNo));
        return result;
    }



}
