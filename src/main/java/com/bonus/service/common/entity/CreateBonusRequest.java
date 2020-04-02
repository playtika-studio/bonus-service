package com.bonus.service.common.entity;

import lombok.Builder;
import lombok.Value;

import java.sql.Date;

@Builder
@Value
public class CreateBonusRequest {

    String bonusName;
    String bonusType;

    Date startTime;
    Date endTime;
}
