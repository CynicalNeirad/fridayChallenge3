package com.example.demo.repositories;

import com.example.demo.AppRole;
import com.example.demo.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.util.HashSet;

public interface AppUserRepository  extends CrudRepository<AppUser,Long>{

    AppUser findAppUserByUsername(String username);
    HashSet<AppUser> findByRoles(AppRole r);
    AppUser findById(Long id);

}
