package com.blockchain4life.bean;

import com.blockchain4life.constant.ReturnCode;
import lombok.Data;

/**
 * Description:
 * User: chengran
 * Date: 2020-10-19
 */
@Data
public class Response<T> {

    private String returnCode;

    private String msg;

    private T data;


    public Response(ReturnCode returnCode,String msg,T data){
        this.returnCode = returnCode.getValue();
        this.msg = msg;
        this.data = data;
    }

    public static <T> Response<T> success(T data){
        return new Response(ReturnCode.REQUEST_SUCCESS,null,data);
    }

    public static <T> Response<T> fail(String msg){
        return new Response(ReturnCode.REQUEST_FAILED,msg,null);
    }
}
