package com.beehyv.server.controller;

import com.beehyv.server.entity.Skill;
import com.beehyv.server.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping("/api/v1/skills")
    public List<Skill> fetchAllSkills() {
        return skillService.fetchAllSkills();
    }

    @GetMapping("/api/v1/skills/{skill-id}")
    public Skill fetchSkillById(@PathVariable("skill-id") Long skillId) {
        return skillService.fetchSkillById(skillId);
    }

}
