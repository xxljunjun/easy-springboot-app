package com.example.xxlspringboot.utils.result;


import lombok.Data;

@Data
public class BusinessException extends RuntimeException {
    /**
     * 错误状态码
     */
    protected Integer errorCode;
    /**
     * 错误提示
     */
    protected String errorMsg;

    public BusinessException(){

    }

    public BusinessException(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}