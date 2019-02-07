package com.ching.wechatstudy.utils;

import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 *
 * @author g1344
 */
public class CaseCenterRunTimeException extends RuntimeException{
    private ResultCode resultCode;
    private String message;

    public CaseCenterRunTimeException(ResultCode resultCode,String message){
        this.resultCode = Optional.ofNullable(resultCode).orElse(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        this.message = StringUtils.isEmpty(message)?this.resultCode.message():message;
    }

    public static CaseCenterRunTimeException fromResultCode(ResultCode resultCode){
        return new CaseCenterRunTimeException(resultCode,null);
    }

        public static CaseCenterRunTimeException fromResultCodeWithMsg(ResultCode resultCode,String message){
            return new CaseCenterRunTimeException(resultCode,message);
    }

    public Result toResult(){
       return new Result(this.resultCode.code(),this.message);
    }
    public ResultCode getResultCode(){
        return this.resultCode;
    }

    public String getMessage(){
        return this.message;
    }
}
