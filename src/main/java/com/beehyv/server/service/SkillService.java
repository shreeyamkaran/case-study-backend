package com.beehyv.server.service;

import com.beehyv.server.entity.Skill;

import java.util.List;

public interface SkillService {
    List<Skill> fetchAllSkills();

    Skill fetchSkillById(Long skillId);
}
