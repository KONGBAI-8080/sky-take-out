package com.sky.exception;
/**
 * 用户被锁定异常
 */
public class AccountLockedException extends RuntimeException {
    public AccountLockedException(){

    }

    public AccountLockedException(String message){
        super(message);
    }
}
