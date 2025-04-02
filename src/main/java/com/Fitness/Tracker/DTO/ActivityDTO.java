package com.Fitness.Tracker.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class ActivityDTO {

    private Long id;
    private Double distance;
    private int caloriesBurned;
    private Date date;
    private Integer steps;

}
