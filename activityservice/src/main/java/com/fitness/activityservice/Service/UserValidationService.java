package com.fitness.activityservice.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
@RequiredArgsConstructor
public class UserValidationService {
    private final WebClient userServiceWebClient;

    public boolean validateUser(String userId){
        try {
            return userServiceWebClient.get()
                    .uri("/v1/users/{userId}/validate", userId)
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();
        }
        catch (WebClientResponseException e){
            if(e.getStatusCode()== HttpStatus.NOT_FOUND){
                throw new RuntimeException("User Not Found with user Id "+userId);
            }
            else if(e.getStatusCode()==HttpStatus.BAD_REQUEST){
                throw new RuntimeException("Invalid Request");
            }

        }
        return false;
    }
}
