package com.blockchain4life.controller;

import com.blockchain4life.bean.WithdrawCardInfo;
import com.blockchain4life.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Description: 获取授信机构的信息
 * User: chengran
 * Date: 2020-10-19
 */
@RestController
public class CreditController {

    @Autowired
    private CreditService creditService;

    /**
     * 用户注册成功后，查询授信机构的公钥，页面对身份证、驾驶证等个人信息进行加密
     * @return
     */
    @PostMapping("/getCreditPubKey")
    public String getCreditPubKey(@Valid @RequestBody WithdrawCardInfo info) throws Exception {


        return creditService.sendIdentifyInfoToCredit(info);
    }
}
