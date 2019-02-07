package com.ching.wechatstudy.utils;


public enum  ResultCode {

    /* 成功状态码 */
    SUCCESS(20000, "成功"),

    /* 业务错误：20001-20099*/
    USER_NOT_LOGGED_IN(20001, "用户未登录"),
    USER_LOGIN_ERROR(20002, "账号不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN(20003, "账号已被禁用"),
    USER_NOT_EXIST(20004, "用户不存在"),
    USER_HAS_EXISTED(20005, "用户已存在"),
    RESULE_DATA_NONE(20006, "数据未找到"),
    DATA_IS_WRONG(20007, "数据有误"),
    DATA_ALREADY_EXISTED(20008, "数据已存在"),
    DATA_TOO_BIG(20009, "数据过大"),
    DATA_NOCHANGE(20010, "影响数据0行，数据不存在/参数错误"),

    /* 参数错误：40001-40099 */
    PARAM_NOT_COMPLETE(40001, "参数缺失"),
    PARAM_IS_INVALID(40002, "参数无效"),
    PARAM_IS_BLANK(40003, "参数为空"),
    PARAM_TYPE_BIND_ERROR(40004, "参数类型错误"),

    /* 权限错误：40101-40199*/
    PERMISSION_NO_ACCESS(40101, "无访问权限"),
    INTERFACE_FORBID_VISIT(40102, "该接口禁止访问"),

    /* 鉴权错误：40301*/
    FORBIDDEN_SIGN_NULL(40301, "无签名信息"),
    FORBIDDEN_APPID_INVALID(40302, "ID无对应密钥信息"),
    FORBIDDEN_SIGN_INVALID(40303, "签名无效"),

    /* 系统错误：50001-50099 */
    SYSTEM_INNER_ERROR(50001, "系统繁忙，请稍后重试"),
    INTERFACE_INNER_INVOKE_ERROR(50002, "内部系统接口调用异常"),
    INTERFACE_OUTTER_INVOKE_ERROR(50003, "外部系统接口调用异常"),
    INTERFACE_ADDRESS_INVALID(50004, "接口地址无效"),
    INTERFACE_REQUEST_TIMEOUT(50005, "接口请求超时"),
    INTERFACE_EXCEED_LOAD(50006, "接口负载过高");

    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public static String getMessage(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }

}
