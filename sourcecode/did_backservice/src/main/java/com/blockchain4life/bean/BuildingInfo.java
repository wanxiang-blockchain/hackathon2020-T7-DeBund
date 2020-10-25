package com.blockchain4life.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Description:
 * User: chengran
 * Date: 2020-10-24
 */
@Data
@RequiredArgsConstructor
public class BuildingInfo {

    @ApiModelProperty(value = "楼宇的数字身份id")
    private String buildingDidCode;

    @ApiModelProperty(value = "楼宇名称")
    private String buildingName;

    @ApiModelProperty(value = "经度")
    private Double longitude;

    @ApiModelProperty(value = "纬度")
    private Double latitude;


    public BuildingInfo(String buildingDidCode,String buildingName,Double longitude,Double latitude){
        this.buildingDidCode = buildingDidCode;
        this.buildingName = buildingName;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
