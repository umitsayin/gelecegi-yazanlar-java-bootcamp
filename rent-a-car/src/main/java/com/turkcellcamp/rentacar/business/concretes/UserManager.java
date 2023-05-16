package com.turkcellcamp.rentacar.business.concretes;

import com.turkcellcamp.rentacar.business.abstracts.RoleService;
import com.turkcellcamp.rentacar.business.abstracts.UserService;
import com.turkcellcamp.rentacar.business.dto.requests.create.UserCreateDto;
import com.turkcellcamp.rentacar.business.dto.responses.UserResponse;
import com.turkcellcamp.rentacar.entities.User;
import com.turkcellcamp.rentacar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {
    private final UserRepository repository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse register(UserCreateDto request) {
        User user = new User();

        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.getRoles().add(roleService.getByRoleName("ADMIN"));

        repository.save(user);

        return new UserResponse(user.getUsername(),user.getPassword());
    }

    @Override
    public User getByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(()-> new RuntimeException("USER NOT FOUND"));
    }
}
