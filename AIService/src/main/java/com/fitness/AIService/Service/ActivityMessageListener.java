package com.fitness.AIService.Service;


import com.fitness.AIService.Model.Activity;
import com.fitness.AIService.Model.Recommendation;
import com.fitness.AIService.Repository.RecommendationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ActivityMessageListener{
    @Autowired
    private ActivityAIService activityAIService;
    @Autowired
    private RecommendationRepository recommendationRepository;
    @RabbitListener(queues = "activity.queue")
    public void processActivity(Activity activity){
        log.info("Received Activity for activity {}",activity.getId());
//        log.info("Generated Recommendation {}",activityAIService.generateRecommendation(activity));
        Recommendation recommendation=activityAIService.generateRecommendation(activity);
        recommendationRepository.save(recommendation);
    }
}
