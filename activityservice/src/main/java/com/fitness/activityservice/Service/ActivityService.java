package com.fitness.activityservice.Service;

import com.fitness.activityservice.DTO.ActivityRequest;
import com.fitness.activityservice.DTO.ActivityResponse;
import com.fitness.activityservice.Model.Activity;
import com.fitness.activityservice.Repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final UserValidationService userValidationService;
    public ActivityResponse trackActivity(ActivityRequest activityRequest) {
//        boolean isValidUser= userValidationService.validateUser(activityRequest.getUserId());
//        System.out.println("------------------"+isValidUser);
//        if(!isValidUser){
//            throw new RuntimeException("Invalid User:"+activityRequest.getUserId());
//        }
        Activity activity=Activity.builder()
                .userId(activityRequest.getUserId())
                .activityType(activityRequest.getActivityType())
                .duration(activityRequest.getDuration())
                .caloriesBurned(activityRequest.getCaloriesBurned())
                .startTime(activityRequest.getStartTime())
                .additionalMetrics(activityRequest.getAdditionalMetrics())
                .build();

        Activity savedActivity=activityRepository.save(activity);
        return mapToResponse(savedActivity);
    }

    private ActivityResponse mapToResponse(Activity activity){
        ActivityResponse activityResponse=new ActivityResponse();
        activityResponse.setId(activity.getId());
        activityResponse.setUserId(activity.getUserId());
        activityResponse.setActivityType(activity.getActivityType());
        activityResponse.setDuration(activity.getDuration());
        activityResponse.setCaloriesBurned(activity.getCaloriesBurned());
        activityResponse.setStartTime(activity.getStartTime());
        activityResponse.setAdditionalMetrics(activity.getAdditionalMetrics());
        activityResponse.setCreatedAt(activity.getCreatedAt());
        activityResponse.setUpdatedAt(activity.getUpdatedAt());
        return activityResponse;
    }

    public List<ActivityResponse> getUserActivities(String userId) {
        List<Activity> activities=activityRepository.findByUserId(userId);
        return activities.stream().map(
                this::mapToResponse)
                .collect(Collectors.toList());
    }

    public ActivityResponse getActivityById(String activityId) {
        return activityRepository.findById(activityId)
                .map(this::mapToResponse)
                .orElseThrow(()->new RuntimeException("Activity Not Found with id:"+activityId));
    }
}
