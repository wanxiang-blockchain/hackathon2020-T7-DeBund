package com.blockchain4life.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Description:
 * User: chengran
 * Date: 2020-10-24
 */
@Data
public class GetBuildingInfoListRequestInfo {

    @ApiModelProperty(value = "当前经度信息的密文")
    private String longitude;

    @ApiModelProperty(value = "当前纬度信息的密文")
    private String latitude;

    private Double range;
}
