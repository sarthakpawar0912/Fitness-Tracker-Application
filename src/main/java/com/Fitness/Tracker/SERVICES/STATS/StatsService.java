package com.Fitness.Tracker.SERVICES.STATS;

import com.Fitness.Tracker.DTO.GraphDTO;
import com.Fitness.Tracker.DTO.StatsDTO;

public interface StatsService {

    StatsDTO getStats();
    GraphDTO getGraphStats();

}
