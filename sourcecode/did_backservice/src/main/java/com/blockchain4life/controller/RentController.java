package com.blockchain4life.controller;

import com.blockchain4life.bean.ContractInfo;
import com.blockchain4life.bean.Response;
import com.blockchain4life.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Description: 签约租赁合约
 * User: chengran
 * Date: 2020-10-25
 */
@RestController
public class RentController {

    @Autowired
  private RentService rentService;

    /**
     * 签约租赁合约
     * @return
     */
    @PostMapping("/rentContract/sign")
    public Response rentContract(@Valid @RequestBody ContractInfo contractInfo) throws Exception {
        return Response.success(rentService.signRentContract(contractInfo));
    }
}
