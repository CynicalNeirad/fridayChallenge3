package com.example.demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String skill;
    private String proficiency;

    @ManyToMany(mappedBy = "skillsList", fetch = FetchType.LAZY)
    private List<Resume> resumes;

    public List<Resume> getResumes() {
        return resumes;
    }

    public void setResumes(List<Resume> resumes) {
        this.resumes = resumes;
    }
    public Skills(){ resumes = new ArrayList<>();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }
}
