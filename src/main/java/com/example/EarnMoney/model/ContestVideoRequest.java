package com.example.EarnMoney.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class ContestVideoRequest {
    private String videoTitle;
    private String videoUrl;
    private String description;
}

