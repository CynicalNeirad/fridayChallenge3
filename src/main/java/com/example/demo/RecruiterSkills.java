package com.example.demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RecruiterSkills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String jobSkill;

    @ManyToMany(mappedBy = "jobSkills")
    private List<Job> skillsJob;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJobSkill() {
        return jobSkill;
    }

    public void setJobSkill(String jobSkill) {
        this.jobSkill = jobSkill;
    }

    public List<Job> getSkillsJob() {
        return skillsJob;
    }

    public void setSkillsJob(List<Job> skillsJob) {
        this.skillsJob = skillsJob;
    }


    /*
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJobSkill() {
        return jobSkill;
    }

    public void setJobSkill(String jobSkill) {
        this.jobSkill = jobSkill;
    }

    public List<Job> getJobSkills() {
        return jobSkills;
    }

    public void setJobSkills(List<Job> jobSkills) {
        this.jobSkills = jobSkills;
    }*/


}
