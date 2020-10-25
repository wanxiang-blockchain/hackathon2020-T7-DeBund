package com.blockchain4life.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.security.interfaces.RSAPublicKey;

/**
 * Description: 用户给各类证件进行注册
 * User: chengran
 * Date: 2020-10-24
 */
@Data
public class WithdrawCardInfo {

    private String personDidCode;

    @ApiModelProperty(value = "证件的加密信息，仅由授信机构进行解密")
    private String cardInfoEnc;

    @ApiModelProperty(value = "用户的公钥信息，用来给授信机构加密数据")
    private RSAPublicKey personPublicKey;
}
