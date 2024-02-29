package com.atguigu.ssyx.common.result;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
public class Result<T> {
    //状态码
    private Integer code;
    //信息
    private String message;
    //数据
    private T data;
    //构造私有
    private Result(){ }

    //设置数据的方法
    public static<T> Result<T> build(T data,ResultCodeEnum resultCodeEnum){
        //创建Result对象，设置值。返回对象
        Result<T> Result = new Result<T>();
        if(data != null){
            Result.setData(data);
        }
        Result.setCode(resultCodeEnum.getCode());
        Result.setMessage(resultCodeEnum.getMessage());
        return Result;
    }

    public static<T> Result<T> ok(T data){
        return build(data, ResultCodeEnum.SUCCESS);

    }
    public static<T> Result<T> fail(T data){
        return build(data, ResultCodeEnum.FAIL);
    }

    public static void main(String[] args) {

    }
}

