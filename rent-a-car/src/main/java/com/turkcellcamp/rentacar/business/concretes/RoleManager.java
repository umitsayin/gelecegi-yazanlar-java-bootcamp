package com.turkcellcamp.rentacar.business.concretes;

import com.turkcellcamp.rentacar.business.abstracts.RoleService;
import com.turkcellcamp.rentacar.entities.Role;
import com.turkcellcamp.rentacar.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleManager implements RoleService {
    private final RoleRepository repository;

    @Override
    public Role getByRoleName(String name) {
        return repository.findByName(name)
                .orElseThrow(()-> new RuntimeException("ROLE NOT FOUND"));
    }
}
