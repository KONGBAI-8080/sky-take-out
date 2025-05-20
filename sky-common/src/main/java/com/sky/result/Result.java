package com.sky.result;

import java.io.Serializable;

import lombok.Data;

@Data
public class Result<T> implements Serializable{
    
    // 响应代码
    private Integer code;

    // 响应信息
    private String message;

    // 响应结果数据
    private T data;


    public static <T> Result<T> success(){
        Result<T> result = new Result<T>();
        result.code = 1;
        return result;
    }


    public static <T> Result<T> error(String message){
        Result<T> result = new Result<T>();
        result.code = 0;
        result.message = message;
        return result;
    }

    public static <T> Result<T> success(T object){
        Result<T> result = new Result<T>();
        result.code = 1;
        result.data = object;
        return result;
    }

}
