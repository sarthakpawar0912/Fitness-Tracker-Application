package com.Fitness.Tracker.DTO;


import lombok.Data;


@Data
public class StatsDTO {
    private long achievedGoals;
    private long notAchievedGoals;

    private int steps;

    private Double distance;

    private int  totalCaloriesBurned;
    private  int duration;
}
