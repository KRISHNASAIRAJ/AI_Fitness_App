package com.fitness.AIService.Service;

import com.fitness.AIService.Model.Recommendation;
import com.fitness.AIService.Repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {
    @Autowired
    private RecommendationRepository recommendationRepository;
    public List<Recommendation> getUserRecommendation(String userId) {
        return recommendationRepository.findByUserId(userId);
    }

    public Recommendation getActivityRecommendation(String activityId) {
        return recommendationRepository.findByActivityId(activityId)
                .orElseThrow(()->new RuntimeException("No Recommendation Found For The Activity "+activityId));
    }
}
