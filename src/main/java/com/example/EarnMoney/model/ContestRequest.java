package com.example.EarnMoney.model;

import lombok.Data;

import java.util.Date;

@Data
public class ContestRequest {
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
}
