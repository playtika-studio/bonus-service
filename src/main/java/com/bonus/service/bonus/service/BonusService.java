package com.bonus.service.bonus.service;

import com.bonus.service.bonus.entity.Bonus;
import com.bonus.service.bonus.repository.BonusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BonusService {

    @Autowired
    BonusRepository bonusRepository;

    public void addBonus(Bonus bonus){
        bonusRepository.save(bonus);
    }

    public List<Bonus> getAllBonuses(){
        return bonusRepository.findAll();
    }

    private Optional<Bonus> getBonusById(int id){
        return bonusRepository.findById(id);
    }

    public Bonus updateBonus(Bonus bonus){
         return bonusRepository.save(bonus);
    }

    public void deleteBonusById(int id){
        bonusRepository.deleteById(id);
    }
}
