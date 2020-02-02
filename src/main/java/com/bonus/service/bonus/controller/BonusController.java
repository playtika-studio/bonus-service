package com.bonus.service.bonus.controller;

import com.bonus.service.bonus.entity.Bonus;
import com.bonus.service.bonus.service.BonusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/bonus")
public class BonusController {

    private static final Logger log = LoggerFactory.getLogger(BonusController.class);

    @Autowired
    BonusService bonusService;

    @PostMapping("/addBonus")
    private void addBonus(Bonus bonus){
        log.info("Creating bonus "+bonus.toString());
        bonusService.addBonus(bonus);
        log.info("Bonus "+bonus.toString()+ " was successfully created");
    }

    @GetMapping("/getBonuses")
    private  List<Bonus> getAllBonuses(){
        return bonusService.getAllBonuses();
    }

    @PutMapping("/updateBonus")
    private Bonus updateBonus(Bonus bonus){
        return bonusService.updateBonus(bonus);
    }

    @DeleteMapping("/deleteBonus/{id}")
    private void deleteBonusById(int id){
        bonusService.deleteBonusById(id);
    }



}
