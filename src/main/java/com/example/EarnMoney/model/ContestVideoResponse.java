package com.example.EarnMoney.model;

import jakarta.persistence.Entity;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContestVideoResponse {
    private Long id;
    private String videoTitle;
    private String videoUrl;
    private String description;
}
