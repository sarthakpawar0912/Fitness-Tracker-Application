package com.Fitness.Tracker.SERVICES.WORKOUT;

import com.Fitness.Tracker.DTO.WorkoutDTO;

import java.util.List;

public interface WorkoutService {
    WorkoutDTO postWorkout(WorkoutDTO workoutDTO);
    List<WorkoutDTO> getWorkouts();
}
