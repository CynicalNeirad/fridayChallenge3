package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
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
    public String educationInfo(Model model){
        model.addAttribute("education", new Education());
        return "educationhtml";
    }

    @GetMapping("/skills")
    public String skillsInfo(Model model){
        model.addAttribute("skill", new Skills());
        return "skillhtml";
    }

    @GetMapping("/experience")
    public String experienceInfo(Model model){
        model.addAttribute("experiences", new Experience());
        return "experiencehtml";
    }

    @GetMapping("/refrences")
    public String refrencesInfo(Model model){
        return "refrenceshtml";
    }

    @GetMapping("/resume")
    public String fullresume(Model model){
        model.addAttribute("resume", resumeStore.findAll());
        return "resumehtml";
    }

    @GetMapping("/coverletter")
    public String coverletter(Model model){
        return "coverletter";
    }

    @PostMapping("/processeducation")
    public String processEducation(@Valid Education education, BindingResult result) {
        if (result.hasErrors()) {
            return "educationhtml";
        }
        educationStore.save(education);
        return "redirect:/educationAdded";}


    @PostMapping("/processskill")
    public String processSkill(@Valid Skills skills, BindingResult result) {
        if (result.hasErrors()) {
            return "skillshtml";
        }
        skillsStore.save(skills);
        return "redirect:/skillAdded";}


    @PostMapping("/processexperience")
    public String processExperience(@Valid Experience experience, BindingResult result) {
        if (result.hasErrors()) {
            return "experiencehtml";
        }
        experienceStore.save(experience);
        return "redirect:/experienceAdded";}

    @PostMapping("/processContact")
    public String processContact(@Valid Resume resume, BindingResult result) {
        if (result.hasErrors()) {
            return "contacts";
        }
        resumeStore.save(resume);
        return "/contactAdded";}
}
