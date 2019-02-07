package com.ching.wechatstudy.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {

    private Integer returnCode;

    private String returnMsg;

    private Object data;

    private List<Object> datas;

    private Map<Object, Object> extendData;

    public Result() {}

    public Result(Integer returnCode, String returnMsg) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }

    public static Result success() {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }
    public static Result success(Object data) {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result success(Object data, Map<Object, Object> extendData) {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        result.setExtendData(extendData);
        return result;
    }

    public static Result success(List<Object> datas, Map<Object, Object> extendData) {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setDatas(datas);
        result.setExtendData(extendData);
        return result;
    }

    public static Result failure(ResultCode resultCode) {
        Result result = new Result();
        result.setResultCode(resultCode);
        return result;
    }

    public static Result failure(ResultCode resultCode, Object data) {
        Result result = new Result();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }

    public void setResultCode(ResultCode code) {
        this.returnCode = code.code();
        this.returnMsg = code.message();
    }

}
