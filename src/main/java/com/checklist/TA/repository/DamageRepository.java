package com.checklist.TA.repository;

import com.checklist.TA.bo.Damage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DamageRepository extends JpaRepository<Damage,Long> {
}
