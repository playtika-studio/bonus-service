package com.bonus.service.bonus.repository;

import com.bonus.service.common.entity.Bonus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonusRepository extends CrudRepository<Bonus,Integer> {

}
