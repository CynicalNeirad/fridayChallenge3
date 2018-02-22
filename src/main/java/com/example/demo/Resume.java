package com.example.demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String resumeImg;
    private String name;
    private String email;


    @ManyToMany
    private List<Educations> educationList;

    @ManyToMany
    private List<Skills> skillsList;

    @ManyToMany
    private List<Experiences> experienceList;

    @ManyToMany(mappedBy = "resumeList")
    private List <AppUser> appUser;

    public Resume() {
        this.educationList=new ArrayList<>();
        this.skillsList=new ArrayList<>();
        this.experienceList=new ArrayList<>();
    }

    public void addEducation(Educations p){ this.educationList.add(p);}
    public void addSkills(Skills p){this.skillsList.add(p);}
    public void addExperience(Experiences p){ this.experienceList.add(p);}


    public List<AppUser> ge1tAppUser() {
        return appUser;
    }

    public void setAppUser(List<AppUser> appUser) {
        this.appUser = appUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getResumeImg() {
        return resumeImg;
    }

    public void setResumeImg(String resumeImg) {
        this.resumeImg = resumeImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Educations> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Educations> educationList) {
        this.educationList = educationList;
    }

    public List<Skills> getSkillsList() {
        return skillsList;
    }

    public void setSkillsList(List<Skills> skillsList) {
        this.skillsList = skillsList;
    }

    public List<Experiences> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(List<Experiences> experienceList) {
        this.experienceList = experienceList;
    }
}
