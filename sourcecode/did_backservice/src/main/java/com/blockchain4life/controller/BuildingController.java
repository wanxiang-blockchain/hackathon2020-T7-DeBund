package com.blockchain4life.controller;

import com.blockchain4life.bean.GetBuildingInfoDetailRequestInfo;
import com.blockchain4life.bean.GetBuildingInfoListRequestInfo;
import com.blockchain4life.bean.Response;
import com.blockchain4life.service.BuildingManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Description: 楼宇管理
 * User: chengran
 * Date: 2020-10-20
 */
@RestController
public class BuildingController {

    @Autowired
    BuildingManagerService buildingManagerService;

    /**
     * 返回当前位置的附近楼宇的列表信息
     * @return
     */
    @PostMapping("/getRangeBuildingInfo/list")
    public Response getBuildingInfoList(@Valid @RequestBody GetBuildingInfoListRequestInfo info){

        return Response.success(buildingManagerService.getBuildingInfoList(info));
    }

    /**
     * 返回选定楼宇的详细信息
     * @return
     */
    @PostMapping("/getBuildingInfo/detail")
    public Response getBuildingInfoDetail(@Valid @RequestBody GetBuildingInfoDetailRequestInfo info){

        return Response.success(buildingManagerService.getBuildingDetailInfoList(info));
    }



}
