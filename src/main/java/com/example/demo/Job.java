package com.example.demo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String jobTitle;
    private String jobOrganization;

    @ManyToMany
    private List<JobSkill> jobSkill;

    @ManyToMany(mappedBy = "postedJobs")
    private List<Recruiter> recruiter;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobOrganization() {
        return jobOrganization;
    }

    public void setJobOrganization(String jobOrganization) {
        this.jobOrganization = jobOrganization;
    }

    public List<JobSkill> getJobSkills() {
        return jobSkill;
    }

    public void setJobSkills(List<JobSkill> jobSkills) {
        this.jobSkill = jobSkills;
    }

    public List<Recruiter> getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(List<Recruiter> recruiter) {
        this.recruiter = recruiter;
    }
}
