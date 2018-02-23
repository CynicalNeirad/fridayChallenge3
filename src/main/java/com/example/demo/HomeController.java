package com.example.demo;


import com.example.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    ResumeRepository resumeStore;
    @Autowired
    SkillsRepository skillsStore;
    @Autowired
    EducationRepository educationStore;
    @Autowired
    ExperienceRepository experienceStore;
    @Autowired
    AppUserRepository userStore;

    @GetMapping("/")
    public String directory(Model model) {
        return "mainpage"; }

    @GetMapping("/summary")
    public String resumeSummary(Model model){
        return "summaryhtml";}

    @GetMapping("/contact")
    public String contactInfo(Model model){
        model.addAttribute("contact", new Resume());
        return "contacthtml";
    }

    @GetMapping("/education")
    public String educationInfo(Resume resume, Model model){
        model.addAttribute("education", new Educations());
        return "educationhtml";
    }

    @GetMapping("/skills")
    public String skillsInfo(Model model){
        model.addAttribute("skill", new Skills());
        return "skillhtml";
    }

    @GetMapping("/experience")
    public String experienceInfo(Model model){
        model.addAttribute("experiences", new Experiences());
        return "experiencehtml";
    }

    @GetMapping("/refrences")
    public String refrencesInfo(Model model){
        return "refrenceshtml";
    }

    @GetMapping("/resume")
    public String fullresume(Model model, Authentication authentication){
        AppUser userResume = userStore.findAppUserByUsername(authentication.getName());
        model.addAttribute("currentUser", userResume);

        return "resumehtml";
    }

    @GetMapping("/coverletter")
    public String coverletter(Model model){
        return "coverletter";
    }

    @PostMapping("/processeducation")
    public String processEducation(@Valid Educations education, BindingResult result, Authentication authentication) {
        if (result.hasErrors()) {
            return "educationhtml";
        }
        educationStore.save(education);
        AppUser userId = userStore.findAppUserByUsername(authentication.getName());
        userId.addEducation(education);
        userStore.save(userId);

        return "educationAdded";}


    @PostMapping("/processskill")
    public String processSkill(@Valid Skills skills, BindingResult result, Authentication authentication) {
        if (result.hasErrors()) {
            return "skillshtml";
        }
        skillsStore.save(skills);
        AppUser userId = userStore.findAppUserByUsername(authentication.getName());
        userId.addSkills(skills);
        userStore.save(userId);
        return "skillAdded";}


    @PostMapping("/processexperience")
    public String processExperience(@Valid Experiences experience, BindingResult result, Authentication authentication) {
        if (result.hasErrors()) {
            return "experiencehtml";
        }
        experienceStore.save(experience);
        AppUser userId = userStore.findAppUserByUsername(authentication.getName());
        userId.addExperience(experience);
        userStore.save(userId);
        return "experienceAdded";}

    @PostMapping("/processContact")
    public String processContact(@Valid Resume resume, BindingResult result, Authentication authentication) {
        if (result.hasErrors()) {
            return "contacts";
        }
        resumeStore.save(resume);
        AppUser userId = userStore.findAppUserByUsername(authentication.getName());
        userId.addResume(resume);
        userStore.save(userId);
        return "contactAdded";}

    @GetMapping("/login")
    public String login(Model model){
        return "login";}

}
