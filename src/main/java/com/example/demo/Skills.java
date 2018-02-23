package com.example.demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String skill;
    private String proficiency;

    @ManyToMany(mappedBy = "skillsList", fetch = FetchType.LAZY)
    private List<AppUser> user;

    public List<AppUser> getUser() {
        return user;
    }

    public void setUser(List<AppUser> user) {
        this.user = user;
    }
    public Skills(){ user = new ArrayList<>();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

    @Override
    public String toString() {
        return "Skills{" +
                "id=" + id +
                ", skill='" + skill + '\'' +
                ", proficiency='" + proficiency + '\'' +
                ", user=" + user +
                '}';
    }
}
