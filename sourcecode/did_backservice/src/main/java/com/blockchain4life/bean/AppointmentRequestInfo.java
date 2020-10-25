package com.blockchain4life.bean;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Description:
 * User: chengran
 * Date: 2020-10-25
 */
@Data
public class AppointmentRequestInfo {

    private String creatAppointmentPersonDidCode;
    private String acceptAppointmentPersonDidCode;
    private LocalDateTime dateTime;

}
