package com.example.demo.repositories;
import com.example.demo.Educations;
import com.example.demo.Resume;
import org.springframework.data.repository.CrudRepository;
public  interface EducationRepository extends CrudRepository<Educations, Long>{
    Educations findById(Long id);


}


