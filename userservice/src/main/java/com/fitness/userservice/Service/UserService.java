package com.fitness.userservice.Service;

import com.fitness.userservice.DTO.RegisterRequest;
import com.fitness.userservice.DTO.UserResponse;
import com.fitness.userservice.Entity.User;
import com.fitness.userservice.Repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserResponse register(@Valid RegisterRequest registerRequest) {
//        if(userRepository.existsByEmail(registerRequest.getEmail())){
//            throw new RuntimeException("Email Already Exists");
//        }

        User user=new User();
        user.setEmail(registerRequest.getEmail());
        user.setPassword((registerRequest.getPassword()));
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        User savedUser=userRepository.save(user);
        UserResponse userResponse=new UserResponse();
        userResponse.setId(savedUser.getId());
        userResponse.setPassword(savedUser.getPassword());
        userResponse.setEmail(savedUser.getEmail());
        userResponse.setFirstName(savedUser.getFirstName());
        userResponse.setLastName(savedUser.getLastName());
        userResponse.setCreatedAt(savedUser.getCreatedAt());
        userResponse.setUpdatedAt(savedUser.getUpdatedAt());
        return userResponse;
    }

    public UserResponse getUserProfile(Long userId) {
        User user=userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User Not Found"));
        UserResponse userResponse=new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setPassword(user.getPassword());
        userResponse.setEmail(user.getEmail());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setCreatedAt(user.getCreatedAt());
        userResponse.setUpdatedAt(user.getUpdatedAt());
        return userResponse;
    }

    public Boolean existByUserId(Long userId) {
        return userRepository.existsById(userId);
    }
}
