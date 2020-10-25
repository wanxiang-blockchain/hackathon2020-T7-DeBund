package com.blockchain4life.service;

import com.blockchain4life.bean.WithdrawCardInfo;
import com.blockchain4life.mock.MockAuthorityData;
import org.springframework.stereotype.Service;

/**
 * Description: 与授信机构交互，客户端的加密数据传给授信机构，获取授信机构的证书
 * 此过程数据全部加密，本服务端仅作为一个传输作用
 * User: chengran
 * Date: 2020-10-24
 */
@Service
public class CreditService {


     public String sendIdentifyInfoToCredit(WithdrawCardInfo withdrawCardInfo) throws Exception {

          return  MockAuthorityData.verifyPersonIdentify(withdrawCardInfo);
     }
}
