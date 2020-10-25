package com.blockchain4life.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Description:
 * User: chengran
 * Date: 2020-10-24
 */
@Data
public class GetBuildingInfoDetailRequestInfo {

    @ApiModelProperty(value = "楼宇的数字身份id")
    private String buildingDidCode;
}
