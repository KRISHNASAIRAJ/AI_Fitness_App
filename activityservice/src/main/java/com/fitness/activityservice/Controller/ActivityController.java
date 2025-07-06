package com.fitness.activityservice.Controller;


import com.fitness.activityservice.DTO.ActivityRequest;
import com.fitness.activityservice.DTO.ActivityResponse;
import com.fitness.activityservice.Service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping("/register")
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest activityRequest){
        return ResponseEntity.ok(activityService.trackActivity(activityRequest));
    }

    @GetMapping("/activity")
    public ResponseEntity<List<ActivityResponse>> getUserActivities(@RequestHeader("X-User-ID") String userId){
        return ResponseEntity.ok(activityService.getUserActivities(userId));
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<ActivityResponse> getActivity(@PathVariable String activityId){
        return ResponseEntity.ok(activityService.getActivityById(activityId));
    }
}
