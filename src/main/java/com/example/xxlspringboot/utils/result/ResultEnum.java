package com.example.xxlspringboot.utils.result;

public enum ResultEnum {
    // 枚举定义
    SUCCESS(200, "success"),
    NO_PERMISSION(403,"无查看权限"),
    INTERNAL_SERVER_ERROR(500, "服务器异常请联系管理员"),
    ;

    /** 错误码 */
    private Integer code;

    /** 错误信息 */
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
