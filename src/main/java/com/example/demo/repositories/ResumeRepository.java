package com.example.demo.repositories;
import com.example.demo.Resume;
import org.springframework.data.repository.CrudRepository;
public  interface ResumeRepository extends CrudRepository<Resume, Long>{
    Resume findById(Long id);

}


