package com.Fitness.Tracker.DTO;

import lombok.Data;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Data
public class GraphDTO {

    private List<WorkoutDTO> workouts;
    private List<ActivityDTO> activities;

}
