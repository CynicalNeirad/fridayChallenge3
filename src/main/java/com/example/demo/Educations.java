package com.example.demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Educations {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String education;

    @ManyToMany(mappedBy = "educationList", fetch = FetchType.LAZY)
    private List<AppUser> appUsers;

    public Educations(){
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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Educations{" +
                "id=" + id +
                ", education='" + education + '\'' +
                ", appUsers=" + appUsers +
                '}';
    }
}
