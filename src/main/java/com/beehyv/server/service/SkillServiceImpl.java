package com.beehyv.server.service;

import com.beehyv.server.entity.Skill;
import com.beehyv.server.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public List<Skill> fetchAllSkills() {
        return skillRepository.findAll();
    }

    @Override
    public Skill fetchSkillById(Long skillId) {
        return skillRepository.findById(skillId).orElse(null);
    }

}
