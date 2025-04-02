package com.Fitness.Tracker.SERVICES.ACTIVITY;

import com.Fitness.Tracker.DTO.ActivityDTO;
import com.Fitness.Tracker.ENTITY.Activity;
import com.Fitness.Tracker.REPOSITORY.ActivityRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityServiceImpl implements  ActivityService{

    private final ActivityRepository activityRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public ActivityDTO postActivity(ActivityDTO  dto){
        Activity activity=new Activity();

        activity.setDate(dto.getDate());
        activity.setSteps(dto.getSteps());
        activity.setDistance(dto.getDistance());
        activity.setCaloriesBurned(dto.getCaloriesBurned());

        return activityRepository.save(activity).getActivityDTO();
    }

    public List<ActivityDTO> getActivities(){
        List<Activity> activities=activityRepository.findAll();
        return activities.stream() .map(Activity::getActivityDTO).collect(Collectors.toList());
    }

}
