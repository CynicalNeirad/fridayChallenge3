package com.example.demo.repositories;

import com.example.demo.AppRole;
import org.springframework.data.repository.CrudRepository;

public interface AppRoleRepository extends CrudRepository<AppRole,Long>{
    AppRole findAppRoleByRoleName(String roleName);
}
