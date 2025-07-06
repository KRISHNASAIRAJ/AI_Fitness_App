package com.fitness.userservice.Repository;

import com.fitness.userservice.Entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(@NotBlank(message = "Email is required") @Email(message = "Invalid Email Format") String email);
}
