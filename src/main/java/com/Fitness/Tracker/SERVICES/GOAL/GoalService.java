package com.Fitness.Tracker.SERVICES.GOAL;

import com.Fitness.Tracker.DTO.GoalDTO;
import java.util.List;

public interface GoalService {

    GoalDTO postGoal(GoalDTO dto);
    List<GoalDTO> getGoals();
    GoalDTO updateStatus(Long id);

}
