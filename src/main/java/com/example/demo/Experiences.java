package com.example.demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Experiences {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String experience;

    @ManyToMany(mappedBy = "experienceList", fetch = FetchType.LAZY)
    private List<Resume> resumes;

    public Experiences(){
        this.resumes = new ArrayList<>();
    }


    public List<Resume> getResumes() {
        return resumes;
    }

    public void setResumes(List<Resume> resumes) {
        this.resumes = resumes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
