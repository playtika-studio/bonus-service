package com.bonus.service.common.service;

import com.bonus.service.common.entity.Bonus;
import com.bonus.service.common.exceptions.BonusException;
import com.bonus.service.common.entity.CreateBonusRequest;
import com.bonus.service.bonus.repository.BonusOperations;
import com.bonus.service.bonus.repository.BonusRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class BonusService implements BonusOperations {

    BonusRepository bonusRepository;

    @Autowired
    public BonusService(BonusRepository bonusRepository){
        this.bonusRepository = bonusRepository;
    }

    @Override
    public Bonus addBonus(CreateBonusRequest createBonusRequest) {
        Bonus bonus = Bonus.builder()
                .bonusName(createBonusRequest.getBonusName())
                .bonusType(createBonusRequest.getBonusType())
                .startTime(createBonusRequest.getStartTime())
                .endTime(createBonusRequest.getEndTime()).build();
        log.info("Bonus is "+bonus.toString());
        return bonusRepository.save(bonus);
    }

    @Override
    public List<Bonus> getAllBonuses() {
        return (List<Bonus>) bonusRepository.findAll();
    }

    @Override
    public Optional<Bonus> getbonusById(Integer id) {
        return bonusRepository.findById(id);
    }

    public Bonus updateBonus(int bonusId, CreateBonusRequest createBonusRequest) throws BonusException {
        Optional<Bonus> bonus = bonusRepository.findById(bonusId);
        Bonus updateBonus;
        if(bonus.isPresent()){
             updateBonus = Bonus.builder()
                    .id(bonusId)
                    .bonusName(createBonusRequest.getBonusName())
                    .bonusType(createBonusRequest.getBonusType())
                    .startTime(createBonusRequest.getStartTime())
                    .endTime(createBonusRequest.getEndTime()).build();
            bonusRepository.save(updateBonus);
        }else{
            throw new BonusException("Bonus with id "+bonusId +" does not exist.");
        }
        return updateBonus;
    }

    @Override
    public void deleteBonusById(int id){
        bonusRepository.deleteById(id);
    }
}
