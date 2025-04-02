package com.Fitness.Tracker.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class GoalDTO {

    private Long id;
    private String description;
    private Date startDate;  // Changed startdate → startDate
    private Date endDate;    // Changed enddate → endDate
    private boolean achieved;

}
