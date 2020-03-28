package com.bonus.service.bonus.repository;

import com.bonus.service.bonus.entity.Bonus;
import com.bonus.service.bonus.entity.CreateBonusRequest;

import java.util.List;
import java.util.Optional;

public interface BonusOperations {

    Bonus addBonus(CreateBonusRequest createBonusRequest);

    List<Bonus> getAllBonuses();

    Optional<Bonus> getbonusById(Integer id);

    Bonus updateBonus(int bonusId, CreateBonusRequest createBonusRequest) throws Exception;

    void deleteBonusById(int id);
}
