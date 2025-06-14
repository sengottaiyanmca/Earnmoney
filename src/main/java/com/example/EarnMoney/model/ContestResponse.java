package com.example.EarnMoney.model;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContestResponse {
    private Long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private List<ContestVideoResponse> videos;
}

