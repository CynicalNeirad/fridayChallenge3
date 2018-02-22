package com.example.demo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Recruiter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String recName;
    private String recOrganization;

    @ManyToMany
    private List<Job> postedJobs;


    public long getId()  {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRecName() {
        return recName;
    }

    public void setRecName(String recName) {
        this.recName = recName;
    }

    public String getRecOrganization() {
        return recOrganization;
    }

    public void setRecOrganization(String recOrganization) {
        this.recOrganization = recOrganization;
    }

    public List<Job> getPostedJobs() {
        return postedJobs;
    }

    public void setPostedJobs(List<Job> postedJobs) {
        this.postedJobs = postedJobs;
    }
}
