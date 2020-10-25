package com.blockchain4life.controller;

import com.blockchain4life.bean.LoginInfo;
import com.blockchain4life.bean.Response;
import com.blockchain4life.bean.WithdrawCardInfo;
import com.blockchain4life.service.CreditService;
import com.blockchain4life.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Description: 与用户直接交互的部分，包含注册、登录、查询用户授信信息
 * User: chengran
 * Date: 2020-10-19
 */
@RestController
public class UserController {

    @Autowired
    CreditService creditService;

    @Autowired
    UserService userService;

    /**
     * 用户登录，拿到授信机构返回的证书
     * @return
     */
    @PostMapping("/login")
    public Response login(@Valid @RequestBody LoginInfo info){

        return Response.success(userService.login(info));
    }

    /**
     * 用户注册：将用户的用户名、加密后的密码保存，
     * 身份证的加密信息透传到授信机构，不做存储
     * @return
     */
    @PostMapping("/registry")
    public Response registry(@Valid @RequestBody WithdrawCardInfo info) throws Exception {

        return Response.success(creditService.sendIdentifyInfoToCredit(info));
    }

    /**
     * 用户注册：将用户的用户名、加密后的密码保存，
     * 身份证的加密信息透传到授信机构，不做存储
     * @return
     */
    @PostMapping("/registryCertification")
    public Response registryCertification(@Valid @RequestBody WithdrawCardInfo info) throws Exception {

        return Response.success(creditService.sendIdentifyInfoToCredit(info));
    }

}
