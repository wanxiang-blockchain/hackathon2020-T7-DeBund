package com.blockchain4life.mock;

import com.blockchain4life.BusinessException;
import com.blockchain4life.bean.WithdrawCardInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Base64Utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 模拟多个授信机构的服务
 * User: chengran
 * Date: 2020-10-24
 */
public class MockAuthorityData {
    /*rsa 的公钥*/
    private static RSAPublicKey rsaPublicKey;
    /*rsa 的私钥*/
    private static RSAPrivateKey rsaPrivateKey;


    /*车管所*/
    public static Map<Integer,Map<Integer,String>> CAR_MANAGER_ORGANIZATION = new HashMap<>();



    public String verifyCarIdentify(WithdrawCardInfo withdrawCardInfo) throws Exception {
        String cardInfoEnc = withdrawCardInfo.getCardInfoEnc();
        String clearText = rsaDecrypt(cardInfoEnc);
        if (StringUtils.isNotBlank(clearText) && StringUtils.equals(clearText,CAR_MANAGER_ORGANIZATION.get(withdrawCardInfo.getPersonDidCode()).get("personDidCode").toString())){
            //验证成功，则需要返回证书的密文
            String certifation = "mock certification after verify success";
            return rsaEncrypt(certifation,withdrawCardInfo.getPersonPublicKey());
        }
        throw new BusinessException("验证失败");
    }

    /**派出所 CITIZEN MANAGEMENT SYSTEM*/
    public static Map<Integer,Map<Integer,String>> POLICE_ORGANIZATION = new HashMap<>();

    public static String verifyPersonIdentify(WithdrawCardInfo withdrawCardInfo) throws Exception {
        String cardInfoEnc = withdrawCardInfo.getCardInfoEnc();
        String clearText = rsaDecrypt(cardInfoEnc);
        if (StringUtils.isNotBlank(clearText) && StringUtils.equals(clearText,POLICE_ORGANIZATION.get(withdrawCardInfo.getPersonDidCode()).get("personDidCode").toString())){
            //验证成功，则需要返回证书的密文
            String certifation = "mock certification after verify success";
            return rsaEncrypt(certifation,withdrawCardInfo.getPersonPublicKey());
        }
        throw new BusinessException("验证失败");
    }


    /**
     * rsa解密算法
     */
    private static String  rsaDecrypt(String cipherText) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        //1.获取加密算法工具类对象
        Cipher cipher = Cipher.getInstance("RSA");
        //2.对工具类对象进行初始化
        cipher.init(Cipher.ENCRYPT_MODE,rsaPrivateKey);

        //3.用加密工具类
        byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText.getBytes()));
        String decryptResult = new String(plainText,"GB2312");
        System.out.println(cipherText + "使用RSA解密之后的密文：" + decryptResult);
        return decryptResult;
    }

    /**
     * rsa加密算法
     */
    private static String  rsaEncrypt(String plainText,RSAPublicKey rsaPublicKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        //1.获取加密算法工具类对象
        Cipher cipher = Cipher.getInstance("RSA");
        //2.获取公私钥，存储到静态变量中
        getPubAndPrivKey();
        //3.对工具类对象进行初始化
        cipher.init(Cipher.ENCRYPT_MODE,rsaPublicKey);
        //4.用加密工具类
        byte[] cipherText = cipher.doFinal(plainText.getBytes());
        String encryptResult = new String(Base64Utils.encode(cipherText));
        System.out.println(plainText + "使用rsa加密之后的密文：" + encryptResult);
        return encryptResult;
    }

    private static void getPubAndPrivKey() throws NoSuchAlgorithmException {
        System.out.println("getPubAndPrivKey start...");
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器，密钥大小为96-1024位
        keyPairGen.initialize(1024,new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        // 得到私钥
        rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
        // 得到公钥
        rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
        System.out.println("privateKey: " + rsaPrivateKey.toString());
        System.out.println("rsaPublicKey: " + rsaPublicKey.toString());
        System.out.println("getPubAndPrivKey end...");
    }
}
