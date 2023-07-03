package com.example.xxlspringboot.utils.result;

import lombok.Data;

@Data
public class ResultResponse {
    //是否成功
    private Boolean success;
    //状态码
    private Integer code;
    //提示信息
    private String msg;
    //数据
    private Object data;

    public ResultResponse() {}
    // 自定义构造方法
    public ResultResponse(Boolean success,Integer code, String msg,Object data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    // 自定义异常
    public static ResultResponse customException(BusinessException be){
        ResultResponse result = new ResultResponse();
        result.setSuccess(false);
        result.setCode(be.getErrorCode());
        result.setMsg(be.getErrorMsg());
        result.setData(null);
        return result;
    }
    // 其他异常
    public static ResultResponse otherException(ResultEnum resultEnum){
        ResultResponse result = new ResultResponse();
        result.setSuccess(false);
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMessage());
        result.setData(null);
        return result;
    }
}