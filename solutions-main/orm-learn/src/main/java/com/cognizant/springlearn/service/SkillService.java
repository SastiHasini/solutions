package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Skill;
import com.cognizant.springlearn.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Transactional
    public Skill get(int id) {
        Optional<Skill> skill = skillRepository.findById(id);
        return skill.orElse(null);
    }

    @Transactional
    public void save(Skill skill) {
        skillRepository.save(skill);
    }
}