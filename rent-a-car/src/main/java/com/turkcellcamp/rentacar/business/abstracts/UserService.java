package com.turkcellcamp.rentacar.business.abstracts;

import com.turkcellcamp.rentacar.business.dto.requests.create.UserCreateDto;
import com.turkcellcamp.rentacar.business.dto.responses.UserResponse;
import com.turkcellcamp.rentacar.entities.User;

public interface UserService {
    UserResponse register(UserCreateDto request);
    User getByUsername(String username);
}
