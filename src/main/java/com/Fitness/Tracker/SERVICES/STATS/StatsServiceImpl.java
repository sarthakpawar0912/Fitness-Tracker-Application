package com.Fitness.Tracker.SERVICES.STATS;


import com.Fitness.Tracker.DTO.GraphDTO;
import com.Fitness.Tracker.DTO.StatsDTO;
import com.Fitness.Tracker.ENTITY.Activity;
import com.Fitness.Tracker.ENTITY.Workout;
import com.Fitness.Tracker.REPOSITORY.ActivityRepository;
import com.Fitness.Tracker.REPOSITORY.GoalRepository;
import com.Fitness.Tracker.REPOSITORY.WorkoutRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatsServiceImpl implements  StatsService {

    private final GoalRepository goalRepository ;
    private final ActivityRepository activityRepository;
    private final WorkoutRepository   workoutRepository;

    public StatsServiceImpl(GoalRepository goalRepository, ActivityRepository activityRepository, WorkoutRepository workoutRepository) {
        this.goalRepository = goalRepository;
        this.activityRepository = activityRepository;
        this.workoutRepository = workoutRepository;
    }

    public StatsDTO getStats() {
        Long achievedGoals = goalRepository.countAchievedGoals();
        Long notAchievedGoals = goalRepository.countNotAchievedGoals();

        Integer totalSteps=activityRepository .getTotalSteps();
        Double totalDistance=activityRepository.getTotalDistance();
        Integer totalActivityCaloriesBurned=activityRepository.getTotalActivityCalories();


        Integer totalWorkoutDuration=workoutRepository.getTotalDuration();
        Integer totalWorkoutCaloriesBurned=workoutRepository.getTotalCaloriesBurned();


        int totalCaloriesBurned=(totalActivityCaloriesBurned !=null ? totalActivityCaloriesBurned:0)+
                (totalWorkoutCaloriesBurned !=null ? totalWorkoutCaloriesBurned:0);

        StatsDTO dto = new StatsDTO();
        dto.setAchievedGoals(achievedGoals != null ? achievedGoals : 0);
        dto.setNotAchievedGoals(notAchievedGoals != null ? notAchievedGoals : 0); // FIXED


        dto.setSteps(totalSteps !=null ? totalSteps:0);
        dto.setDistance(totalDistance!=null ? totalDistance:0.0);
        dto.setTotalCaloriesBurned(totalCaloriesBurned);
        dto.setDuration(totalWorkoutDuration !=null ? totalWorkoutDuration:0);
        return dto;
    }

    public GraphDTO getGraphStats(){
        Pageable pageable= (Pageable) PageRequest.of(0,7);

        List<Workout> workouts=workoutRepository.findLast7Workouts( pageable);
        List<Activity> activities=activityRepository.findLast7Activities(pageable);

        GraphDTO graphDTO=new GraphDTO();
        graphDTO.setWorkouts(workouts.stream().map(Workout::getWorkoutDTO).collect(Collectors.toList()));
        graphDTO.setActivities(activities.stream().map(Activity::getActivityDTO).collect(Collectors.toList()));

        return graphDTO;
    }

}
