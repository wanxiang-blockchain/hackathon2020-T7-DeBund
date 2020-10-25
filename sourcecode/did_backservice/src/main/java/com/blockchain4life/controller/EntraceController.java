package com.blockchain4life.controller;

import com.blockchain4life.bean.GetBuildingInfoDetailRequestInfo;
import com.blockchain4life.bean.Response;
import com.blockchain4life.service.EntraceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Description: 门禁记录
 * User: chengran
 * Date: 2020-10-25
 */
@RestController
public class EntraceController {

    @Autowired
    EntraceService entraceService;


    /**
     * 返回选定楼宇的详细信息
     * @return
     */
    @PostMapping("/entrace/record")
    public Response getBuildingInfoDetail(@Valid @RequestBody String personDidCode,String  entraceDidCode,String signData) throws Exception {

        return Response.success(entraceService.entranceToBuilding(personDidCode,entraceDidCode));
    }
}
