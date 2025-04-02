package com.Fitness.Tracker.REPOSITORY;

import com.Fitness.Tracker.ENTITY.Workout;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout,Long> {

    @Query("SELECT SUM(w.duration) FROM Workout w ")
    Integer getTotalDuration();

    @Query("SELECT SUM(w.caloriesBurned) FROM Workout w ")
    Integer getTotalCaloriesBurned();

    @Query("SELECT w FROM Workout w ORDER BY w.date DESC")
    List<Workout> findLast7Workouts(Pageable pageable);

}
