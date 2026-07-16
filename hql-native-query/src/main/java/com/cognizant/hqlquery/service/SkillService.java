package com.cognizant.hqlquery.service;

import com.cognizant.hqlquery.model.Skill;
import com.cognizant.hqlquery.repository.SkillRepository;
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
}