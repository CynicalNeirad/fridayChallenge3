package com.example.demo;

import javax.persistence.*;
import java.util.List;

@Entity
public class JobSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String jobSkill;

    @ManyToMany(mappedBy = "jobSkill")
    private List<Job> jobSkills;

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
    }
}
