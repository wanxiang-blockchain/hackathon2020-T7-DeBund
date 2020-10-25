package com.blockchain4life.bean;

import com.blockchain4life.ipfs.api.IPFS;
import lombok.Data;

import java.io.File;
import java.util.List;

/**
 * Description: 业务双方/多方签署合约文件
 * User: chengran
 * Date: 2020-10-24
 */
@Data
public class SaveFileToIpfsRequestInfo {

     private File fileToSave;


}
