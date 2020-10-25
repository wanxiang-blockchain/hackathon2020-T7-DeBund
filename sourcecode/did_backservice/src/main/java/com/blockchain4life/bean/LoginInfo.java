package com.blockchain4life.bean;

import lombok.Data;

/**
 * Description:
 * User: chengran
 * Date: 2020-10-20
 */
@Data
public class LoginInfo {

    private String username;

    private String password;

    private String faceInfo;

    /**登录类型：0-密码/1-人脸识别*/
    private String loginType;
}
