package com.example.demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Educations {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String education;

    @ManyToMany(mappedBy = "educationList", fetch = FetchType.LAZY)
    private List<Resume> resumes;

    public Educations(){
        this.resumes = new ArrayList<>();
    }

    public List<Resume> getResumes() {
        return resumes;
    }

    public void setResumes(List<Resume> resumes) {
        this.resumes = resumes;
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
}
