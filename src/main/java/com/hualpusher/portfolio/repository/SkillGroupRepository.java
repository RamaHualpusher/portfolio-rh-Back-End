package com.hualpusher.portfolio.repository;

import com.hualpusher.portfolio.entity.SkillGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillGroupRepository extends JpaRepository<SkillGroup, Long> {
}
