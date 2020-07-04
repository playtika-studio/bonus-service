package com.bonus.service.bonus;

import com.bonus.service.common.entity.Bonus;
import com.bonus.service.common.entity.CreateBonusRequest;
import com.bonus.service.common.exceptions.BonusException;
import com.bonus.service.common.service.BonusService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = BonusApplication.class
)
@TestPropertySource(locations = "classpath:application-test.properties")
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
public class BonusApplicationTests {

    @Autowired
    private BonusService bonusService;

    @Before
    public void setup(){
        CreateBonusRequest bonus = CreateBonusRequest.builder()
                .bonusName("BonusName")
                .bonusType("MegaBonus")
                .startTime(Date.valueOf(LocalDate.MIN))
                .endTime(Date.valueOf(LocalDate.MAX))
                .build();
        log.info("Creating base bonus");
        bonusService.addBonus(bonus);
    }

    @Test
    public void verifyBonusIsAvailable() {
        List<Bonus> bonuses = bonusService.getAllBonuses();
        log.info("Bonuses are "+bonuses.toString());
        assertThat(bonuses.isEmpty()).isFalse();
    }

    @Test
    public void updateBonus() throws BonusException {
        String bonusName = "NewMegaBonus";
        CreateBonusRequest bonus = CreateBonusRequest.builder()
                .bonusName(bonusName)
                .bonusType("MegaBonus")
                .startTime(Date.valueOf(LocalDate.MIN))
                .endTime(Date.valueOf(LocalDate.MAX))
                .build();
        bonusService.updateBonus(1,bonus);
        assertThat(bonusService.getbonusById(1).get().getBonusName()).isEqualTo(bonusName);
    }

    @Test
    public void updateInvalidBonus() {
        String bonusName = "NewMegaBonus";
        CreateBonusRequest bonus = CreateBonusRequest.builder()
                .bonusName(bonusName)
                .bonusType("MegaBonus")
                .startTime(Date.valueOf(LocalDate.MIN))
                .endTime(Date.valueOf(LocalDate.MAX))
                .build();
        try {
            bonusService.updateBonus(2,bonus);
        } catch (BonusException e) {
           assertThat(e.getMessage()).isEqualTo("Bonus with id 2 does not exist.");
        }
    }

    @Test
    public void deleteBonusById(){
        CreateBonusRequest bonus = CreateBonusRequest.builder()
                .bonusName("DeleteBonus")
                .bonusType("MegaBonus")
                .startTime(Date.valueOf(LocalDate.MIN))
                .endTime(Date.valueOf(LocalDate.MAX))
                .build();
        bonusService.addBonus(bonus);
        assertThat(bonusService.getAllBonuses().size()).isEqualTo(2);
        bonusService.deleteBonusById(2);
        assertThat(bonusService.getbonusById(2)).isEmpty();
    }

}
