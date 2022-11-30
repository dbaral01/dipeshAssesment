package com.charter.assesmentByDipes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyUserRewardReportFormat implements Serializable {
    private Long customerId;
    private Long totalReward;
    private int monthOfTransaction;
    private int yearOfTransaction;

}