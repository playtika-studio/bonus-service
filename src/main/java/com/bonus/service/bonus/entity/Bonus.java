package com.bonus.service.bonus.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Bonus {

    @Id
    @GeneratedValue
    int id;

    private String bonusName;
    private String bonusType;
    private Date startTime;
    private Date endTime;
}
