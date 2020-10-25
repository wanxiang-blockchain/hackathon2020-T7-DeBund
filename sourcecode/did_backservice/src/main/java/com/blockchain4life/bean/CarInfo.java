package com.blockchain4life.bean;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Description:
 * User: chengran
 * Date: 2020-10-24
 */
@Data
public class CarInfo {

    private String carDidCode;

    private LocalDateTime useDate;

    private List<String> licenceDidCodeList;
}
