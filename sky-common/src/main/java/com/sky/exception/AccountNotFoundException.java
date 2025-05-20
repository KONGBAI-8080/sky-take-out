package com.sky.exception;

/**
 * 用户不存在异常
 */
public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(){

    }

    public AccountNotFoundException(String message){
        super(message);
    }
}
