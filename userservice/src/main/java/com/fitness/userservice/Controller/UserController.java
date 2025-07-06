package com.fitness.userservice.Controller;

import com.fitness.userservice.DTO.RegisterRequest;
import com.fitness.userservice.DTO.UserResponse;
import com.fitness.userservice.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserProfile(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getUserProfile(userId));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(userService.register(registerRequest));
    }

    @GetMapping("/{userId}/validate")
    public ResponseEntity<Boolean> validateUser(@PathVariable Long userId){
        return ResponseEntity.ok(userService.existByUserId(userId));
    }
}
