package com.Fitness.Tracker.SERVICES.ACTIVITY;

import com.Fitness.Tracker.DTO.ActivityDTO;

import java.util.List;

public interface ActivityService {
    ActivityDTO postActivity(ActivityDTO  dto);

    List<ActivityDTO> getActivities();
}
