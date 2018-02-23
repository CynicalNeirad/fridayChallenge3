package com.example.demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String jobTitle;
    private String jobOrganization;

    @ManyToMany
    public List<RecruiterSkills> jobSkills;

    @ManyToMany(mappedBy = "jobs")
    private List<AppUser> recruiter;

    public Job(){
        this.jobSkills = new ArrayList<>();
    }

    public void addSkill(RecruiterSkills p){ this.jobSkills.add(p);}

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

    public List<RecruiterSkills> getJobSkills() {
        return jobSkills;
    }

    public void setJobSkills(List<RecruiterSkills> jobSkills) {
        this.jobSkills = jobSkills;
    }

    public List<AppUser> getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(List<AppUser> recruiter) {
        this.recruiter = recruiter;
    }
/*public long getId() {
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

    public List<RecruiterSkills> getJobSkills() {
        return jobSkill;
    }

    public void setJobSkills(List<RecruiterSkills> jobSkills) {
        this.jobSkill = jobSkills;
    }

    public List<AppUser> getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(List<AppUser> recruiter) {
        this.recruiter = recruiter;
    }

    public List<RecruiterSkills> getJobSkill() {
        return jobSkill;
    }

    public void setJobSkill(List<RecruiterSkills> jobSkill) {
        this.jobSkill = jobSkill;
    }*/
}
