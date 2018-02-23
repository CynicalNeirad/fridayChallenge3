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



    @ManyToMany(mappedBy = "resumeList")
    private List <AppUser> appUser;


    public List<AppUser> ge1tAppUser() { return appUser;}

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

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", resumeImg='" + resumeImg + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", appUser=" + appUser +
                '}';
    }
}
