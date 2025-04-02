package com.Fitness.Tracker.CONTROLLER;


import com.Fitness.Tracker.DTO.ActivityDTO;
import com.Fitness.Tracker.SERVICES.ACTIVITY.ActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @PostMapping("/activity")
    public ResponseEntity<?> postActivity(@RequestBody ActivityDTO dto){
        ActivityDTO createActivity=activityService.postActivity(dto);

        if(createActivity!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createActivity);
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some thing Went Wrong...!!");
        }
    }

    @GetMapping("/activities")
    public ResponseEntity<?> getActivities(){
        try {
            return ResponseEntity.ok(activityService.getActivities());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong..!!");
        }
    }

}
