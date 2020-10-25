package com.blockchain4life.controller;

import com.blockchain4life.bean.AppointmentRequestInfo;
import com.blockchain4life.bean.GetBuildingInfoDetailRequestInfo;
import com.blockchain4life.bean.Response;
import com.blockchain4life.service.AppointMentService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;

/**
 * Description: 预约信息处理
 * User: chengran
 * Date: 2020-10-25
 */
@RestController
public class AppointmentController {

    @Autowired
    AppointMentService appointMentService;

    /**
     * 返回选定楼宇的详细信息
     * @return
     */
    @PostMapping("/createAppointment")
    public Response createAppointment(@Valid @RequestBody AppointmentRequestInfo info) throws Exception {

        return Response.success(appointMentService.createAppointment(info));
    }

    /**
     * 审核预约情况
     * @return
     */
    @PostMapping("/auditAppoint")
    public Response acceptAppoint(@Valid @RequestBody AppointmentRequestInfo info) throws Exception {

        return Response.success(appointMentService.acceptAppointment(info));
    }

    /**
     * 返回预约列表
     * @return
     */
    @PostMapping("/getAppointmentInfo/list")
    public Response getAppointmentList(@Valid @RequestBody  String personDidCode){

        return Response.success(new ArrayList<>());
    }
}
