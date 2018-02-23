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
    private List<AppUser> appUsers;

    public Experiences(){
        this.appUsers = new ArrayList<>();
    }


    public List<AppUser> getAppUsers() {
        return appUsers;
    }

    public void setAppUsers(List<AppUser> appUsers) {
        this.appUsers = appUsers;
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

    @Override
    public String toString() {
        return "Experiences{" +
                "id=" + id +
                ", experience='" + experience + '\'' +
                ", appUsers=" + appUsers +
                '}';
    }
}
