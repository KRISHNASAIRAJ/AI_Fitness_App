package com.fitness.activityservice.DTO;


import com.fitness.activityservice.Model.ActivityType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ActivityRequest {
    private String userId;
    private ActivityType activityType;
    private Integer duration;
    private Integer caloriesBurned;
    private LocalDateTime startTime;
    private Map<String,Object> additionalMetrics;
}
