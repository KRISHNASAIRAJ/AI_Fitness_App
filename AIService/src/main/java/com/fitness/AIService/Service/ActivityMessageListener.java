package com.fitness.AIService.Service;


import com.fitness.AIService.Model.Activity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ActivityMessageListener{

    @RabbitListener(queues = "activity.queue")
    public void processActivity(Activity activity){
        log.info("Received Activity for activity {}",activity.getId());
    }
}
