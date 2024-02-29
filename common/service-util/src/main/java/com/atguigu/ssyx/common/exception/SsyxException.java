package com.atguigu.ssyx.common.exception;

import com.atguigu.ssyx.common.result.ResultCodeEnum;

public class SsyxException extends RuntimeException{
    private Integer code;

    public SsyxException(String message,Integer code){
        super(message);
        this.code = code;
    }
    public SsyxException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }
}
