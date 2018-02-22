package com.example.demo.repositories;
import com.example.demo.Skills;
import org.springframework.data.repository.CrudRepository;
public  interface SkillsRepository extends CrudRepository<Skills, Long>{
    Skills findById(Long id);

}


