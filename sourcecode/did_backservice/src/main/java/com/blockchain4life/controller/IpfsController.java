package com.blockchain4life.controller;

import com.blockchain4life.bean.GetFileFromIpfsRequestInfo;
import com.blockchain4life.bean.Response;
import com.blockchain4life.bean.SaveFileToIpfsRequestInfo;
import com.blockchain4life.service.IpfsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;

/**
 * Description:签署合约，存储文件到ipfs，以及从ipfs获取信息
 * User: chengran
 * Date: 2020-10-24
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Validated
@Slf4j
@Api
public class IpfsController {

    @Autowired
    private IpfsService ipfsService;



    @PostMapping("/saveFile/ipfs")
    @ApiModelProperty(value = "保存文件至IPFS")
    public Response saveFileToIpfs(@Valid @RequestParam("file") MultipartFile file) throws  Exception{

        return  Response.success(ipfsService.saveFileToIpfs(file));
    }

    @PostMapping("/getFile/ipfs")
    @ApiModelProperty(value = "从IPFS中获取文件")
    public Response getFileFromIpfs(@Valid @RequestBody GetFileFromIpfsRequestInfo info) throws  Exception{


        return Response.success(ipfsService.getFileFromIpfs(info.getHashValue()));
    }

}
