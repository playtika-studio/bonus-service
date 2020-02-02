package com.bonus.service.bonus.repository;

import com.bonus.service.bonus.entity.Bonus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonusRepository extends JpaRepository<Bonus,Integer> {

}
