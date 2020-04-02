package com.bonus.service.bonus.repository;

import com.bonus.service.common.entity.Bonus;
import com.bonus.service.common.entity.CreateBonusRequest;
import com.bonus.service.common.exceptions.BonusException;

import java.util.List;
import java.util.Optional;

public interface BonusOperations {

    Bonus addBonus(CreateBonusRequest createBonusRequest);

    List<Bonus> getAllBonuses();

    Optional<Bonus> getbonusById(Integer id);

    Bonus updateBonus(int bonusId, CreateBonusRequest createBonusRequest) throws BonusException;

    void deleteBonusById(int id);
}
