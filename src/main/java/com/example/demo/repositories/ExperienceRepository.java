package com.example.demo.repositories;
import com.example.demo.Experiences;
import org.springframework.data.repository.CrudRepository;
public  interface ExperienceRepository extends CrudRepository<Experiences, Long>{
    Experiences findById(Long id);

}


