package com.fitness.activityservice.Repository;

import com.fitness.activityservice.DTO.ActivityResponse;
import com.fitness.activityservice.Model.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends MongoRepository<Activity,String> {
    List<Activity> findByUserId(String userId);
}
