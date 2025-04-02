package com.Fitness.Tracker.SERVICES.GOAL;

import com.Fitness.Tracker.DTO.ActivityDTO;
import com.Fitness.Tracker.DTO.GoalDTO;
import com.Fitness.Tracker.ENTITY.Activity;
import com.Fitness.Tracker.ENTITY.Goal;
import com.Fitness.Tracker.REPOSITORY.GoalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GoalServiceImpl implements GoalService{

    private final GoalRepository goalRepository;

    public GoalServiceImpl(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    public GoalDTO postGoal(GoalDTO dto){
        Goal goal=new Goal();

        goal.setDescription(dto.getDescription());
        goal.setStartDate(dto.getStartDate());
        goal.setEndDate(dto.getEndDate());
        goal.setAchieved(false);

        return goalRepository.save(goal).getGoalDTO();
    }


    public List<GoalDTO> getGoals(){
        List<Goal> goals=goalRepository.findAll();
        return goals.stream() .map(Goal::getGoalDTO).collect(Collectors.toList());
    }


   public GoalDTO updateStatus(Long id){
       Optional<Goal> optionalGoal=goalRepository.findById(id);
       if(optionalGoal.isPresent()){
           Goal existingGoal=optionalGoal.get();

           existingGoal.setAchieved(true);

           return goalRepository.save(existingGoal).getGoalDTO();
       }
       throw new EntityNotFoundException("Goal Not found ..!");
   }
}
