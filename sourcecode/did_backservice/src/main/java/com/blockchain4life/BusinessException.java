package com.blockchain4life;

/**
 * Description:
 * User: chengran
 * Date: 2020-10-25
 */
public class BusinessException extends RuntimeException{

    private String message;

    public BusinessException(String msg){
        super(msg);
    }

}
