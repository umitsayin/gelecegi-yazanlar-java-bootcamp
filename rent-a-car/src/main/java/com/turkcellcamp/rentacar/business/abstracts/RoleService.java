package com.turkcellcamp.rentacar.business.abstracts;

import com.turkcellcamp.rentacar.entities.Role;

public interface RoleService {
    Role getByRoleName(String name);
}
