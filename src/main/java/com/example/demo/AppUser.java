package com.example.demo;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @NotEmpty
    //@Column(unique = true)
    private String username;

    @NotEmpty
    private String password;

    private String userEmail;

    private String fullName;

    public List<Resume> getResumeList() {
        return resumeList;
    }

    public void setResumeList(List<Resume> resumeList) {
        this.resumeList = resumeList;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Resume> resumeList;

    public List<Resume> getUserCartList() {
        return resumeList;
    }

    public void setUserResume(List<Resume> userCartList) {
        this.resumeList = userCartList;
    }

    public void addResume(Resume s){
        this.resumeList.add(s);
    }

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppRole> roles;

    public AppUser() {
        this.roles = new HashSet<>();
        this.resumeList=new ArrayList<>();
    }

    public void addRole(AppRole role){
        this.roles.add(role);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<AppRole> roles) {
        this.roles = roles;
    }
}
