package com.bonus.service.bonus.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
public class Bonus {

    @Id
    @GeneratedValue
//    @ApiModelProperty(hidden=true)
    int id;

    private String bonusName;
    private String bonusType;
    private Date startTime;
    private Date endTime;
}
