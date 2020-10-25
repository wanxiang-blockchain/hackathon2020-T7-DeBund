package com.blockchain4life.mock;

import com.blockchain4life.bean.BuildingInfo;
import com.blockchain4life.bean.ContractInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 模拟数据库
 * User: chengran
 * Date: 2020-10-24
 */
public class MockDatabase {

    /*楼宇列表，key为uuid,value为楼宇的详细信息*/
    public static Map<Integer, BuildingInfo> BUILDING_TABLE = new HashMap<>();
    static {
        BUILDING_TABLE.put(10001,new BuildingInfo("","华虹大厦",
                121.492587,31.253801));
    }

    /*签署合约列表，key为uuid，value为合约关联的*/
    public static Map<String, ContractInfo> CONTRACT_TABLE = new HashMap<>();

    /*门禁记录，key为uuid,value为进出的详细信息*/
    public static Map<String, Map<String,String>> ENTRACE_TABLE = new HashMap<>();
}
