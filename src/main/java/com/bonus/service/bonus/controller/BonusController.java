package com.bonus.service.bonus.controller;

import com.bonus.service.bonus.entity.Bonus;
import com.bonus.service.bonus.entity.CreateBonusRequest;
import com.bonus.service.bonus.exceptions.BonusException;
import com.bonus.service.bonus.repository.BonusOperations;
import com.bonus.service.bonus.service.BonusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/bonus")
public class BonusController {

    private static final Logger log = LoggerFactory.getLogger(BonusController.class);

    @Autowired
    BonusService bonusService;

    @Autowired
    BonusOperations bonusOperations;

    @PostMapping("/addBonus")
    public void addBonus(@RequestBody CreateBonusRequest bonus) {
        bonusOperations.addBonus(bonus);
    }

    @GetMapping("/getAllBonuses")
    public List<Bonus> getBonuses() {
        return bonusOperations.getAllBonuses();
    }

    @GetMapping("/getBonusById")
    public Optional<Bonus> getBonusById(@RequestParam Integer id) {
        return bonusOperations.getbonusById(id);
    }

    @PutMapping("/updateBonus")
    private Bonus updateBonus(@RequestParam Integer bonusId, @RequestBody CreateBonusRequest createBonusRequest) throws BonusException {
        return bonusService.updateBonus(bonusId, createBonusRequest);
    }

    @DeleteMapping("/deleteBonus/{id}")
    private void deleteBonusById(int id) {
        bonusService.deleteBonusById(id);
    }


}
