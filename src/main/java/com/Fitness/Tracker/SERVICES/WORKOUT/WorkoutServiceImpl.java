package com.Fitness.Tracker.SERVICES.WORKOUT;

import com.Fitness.Tracker.DTO.WorkoutDTO;
import com.Fitness.Tracker.ENTITY.Activity;
import com.Fitness.Tracker.ENTITY.Workout;
import com.Fitness.Tracker.REPOSITORY.WorkoutRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class WorkoutServiceImpl implements WorkoutService{

    private final WorkoutRepository workoutRepository;

    public WorkoutServiceImpl(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }


    public WorkoutDTO postWorkout(WorkoutDTO workoutDTO){
        Workout workout=new Workout();


        workout.setDate(workoutDTO.getDate());
        workout.setType(workoutDTO.getType());
        workout.setDuration(workoutDTO.getDuration());
        workout.setCaloriesBurned(workoutDTO.getCaloriesBurned());

        return workoutRepository.save(workout).getWorkoutDTO();
    }


    public List<WorkoutDTO> getWorkouts(){
        List<Workout> workouts=workoutRepository.findAll();
        return workouts.stream() .map(Workout::getWorkoutDTO).collect(Collectors.toList());
    }




}
