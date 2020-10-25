package com.blockchain4life.constant;

import lombok.Getter;

/**
 * Description:
 * User: chengran
 * Date: 2020-10-19
 */
public enum ReturnCode {
    REQUEST_SUCCESS("10000","请求成功"),
    REQUEST_FAILED("10010","请求失败");

    @Getter
    private String value;

    @Getter
    private String desc;

    private ReturnCode(String value,String desc){
        this.value = value;
        this.desc = desc;
    }
}
