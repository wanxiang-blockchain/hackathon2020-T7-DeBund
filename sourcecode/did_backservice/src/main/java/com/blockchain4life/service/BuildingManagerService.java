package com.blockchain4life.service;

import com.blockchain4life.bean.BuildingInfo;
import com.blockchain4life.bean.GetBuildingInfoDetailRequestInfo;
import com.blockchain4life.bean.GetBuildingInfoListRequestInfo;
import com.blockchain4life.mock.MockDatabase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Description:
 * User: chengran
 * Date: 2020-10-24
 */
@Service
public class BuildingManagerService {

    private final static double EARTH_RADIUS = 6371.393;// 地球半径

    /**
     * 获取当前位置一定范围内的列表数据
     * @param info
     * @return
     */
    public List<BuildingInfo> getBuildingInfoList(GetBuildingInfoListRequestInfo info){
        Map<Integer, BuildingInfo> buildingInfoList = MockDatabase.BUILDING_TABLE;
        List<BuildingInfo> collect = buildingInfoList.entrySet()
                .stream().map(item ->
            item.getValue()
        ).filter(item -> {
            //已知两个纬度，计算要求一定范围内距离，经度的差值
             double dlng = 2 * Math.asin(Math.sin(info.getRange()) / (2 * EARTH_RADIUS)) / Math.cos(Double.parseDouble(info.getLatitude()));
             return (item.getLongitude() - dlng )> (Double.parseDouble(info.getLongitude()) - info.getRange());
        }).collect(Collectors.toList());
        return collect;
    }


    /**
     * 获取当前位置一定范围内的列表数据
     * @param info
     * @return
     */
    public BuildingInfo getBuildingDetailInfoList(GetBuildingInfoDetailRequestInfo info){

        return MockDatabase.BUILDING_TABLE.get(info.getBuildingDidCode());
    }

}
