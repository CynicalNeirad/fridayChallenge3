package com.example.demo.config;



import com.example.demo.*;
import com.example.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader  implements CommandLineRunner{

    @Autowired
    AppRoleRepository appRoleRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    SkillsRepository skillsRepository;

    @Autowired
    ResumeRepository resumeRepository;




    @Override
    public void run(String... strings) throws Exception {

        AppRole role = new AppRole();
        role.setRoleName("USER");
        appRoleRepository.save(role);

        role = new AppRole();
        role.setRoleName("Recruit");
        appRoleRepository.save(role);

        role = new AppRole();
        role.setRoleName("ADMIN");
        appRoleRepository.save(role);

        // A few users
        // User 1
        AppUser user = new AppUser();
        user.setUsername("John");
        user.setPassword("password1");
        user.setFullName("John Doe");
        user.setUserEmail("g1@gmail.com");
        user.addRole(appRoleRepository.findAppRoleByRoleName("USER"));
        appUserRepository.save(user);
        // User 2
        user = new AppUser();
        user.setUsername("Jacob");
        user.setPassword("password2");
        user.setFullName("Jacob Smith");
        user.setUserEmail("g2@gmail.com");
        user.addRole(appRoleRepository.findAppRoleByRoleName("USER"));
        appUserRepository.save(user);
        // User 3
        user = new AppUser();
        user.setUsername("Joe");
        user.setPassword("password3");
        user.setFullName("Joe Blow");
        user.setUserEmail("g3@gmail.com");
        user.addRole(appRoleRepository.findAppRoleByRoleName("ADMIN"));
        appUserRepository.save(user);


        Experiences newExperience = new Experiences();
        newExperience.setExperience("Banana");
        experienceRepository.save(newExperience);


        newExperience = new Experiences();
        newExperience.setExperience("Apple");
        experienceRepository.save(newExperience);

        Educations newEducation = new Educations();
        newEducation.setEducation("Scul");
        educationRepository.save(newEducation);

        newEducation = new Educations();
        newEducation.setEducation("School");
        educationRepository.save(newEducation);

        Skills newSkill = new Skills();
        newSkill.setSkill("Skiing");
        newSkill.setProficiency("5");
        skillsRepository.save(newSkill);

        newSkill = new Skills();
        newSkill.setSkill("Snowboarding");
        newSkill.setProficiency("2");
        skillsRepository.save(newSkill);

        Resume newResume = new Resume();
        newResume.addExperience(experienceRepository.findById(new Long(2)));
        newResume.addEducation(educationRepository.findById(new Long(2)));
        newResume.addSkills(skillsRepository.findById(new Long(2)));
        resumeRepository.save(newResume);


        newResume = new Resume();
        newResume.addEducation(educationRepository.findById(new Long(1)));
        newResume.addExperience(experienceRepository.findById(new Long(1)));
        newResume.addSkills(skillsRepository.findById(new Long(1)));
        resumeRepository.save(newResume);


        AppUser appUser=appUserRepository.findOne(new Long(1));
        appUser.addResume(resumeRepository.findById(new Long(1)));
        appUserRepository.save(appUser);
        appUser=appUserRepository.findOne(new Long(3));
        appUser.addResume(resumeRepository.findById(new Long(2)));
        appUserRepository.save(appUser);


    }
}
