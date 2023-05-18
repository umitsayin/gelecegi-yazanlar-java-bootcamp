package com.turkcellcamp.rentacar.utils;

import com.turkcellcamp.rentacar.entities.User;
import com.turkcellcamp.rentacar.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SystemHelper {
    private final UserRepository userRepository;


    public SystemHelper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(Objects.nonNull(authentication)){
            String username = authentication.getName();

            User user = userRepository.findByUsername(username).orElseThrow(()-> new RuntimeException("USER NOT FOUND"));

            return user;
        }

        throw new RuntimeException("USER NOT FOUND");
    }
}
