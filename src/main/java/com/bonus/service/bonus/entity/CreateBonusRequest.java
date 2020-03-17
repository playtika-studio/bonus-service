package com.bonus.service.bonus.entity;


import lombok.Builder;
import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@NotNull
@Valid
@Builder
@Value
public class CreateBonusRequest {

    String bonusName;
    String bonusType;

    Date startTime;
    Date endTime;
}
