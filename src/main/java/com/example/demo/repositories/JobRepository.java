package com.example.demo.repositories;
import com.example.demo.AppUser;
import com.example.demo.Job;
import com.example.demo.Skills;
import org.springframework.data.repository.CrudRepository;
public  interface JobRepository extends CrudRepository<Job, Long>{
    Job findById(Long id);


}


