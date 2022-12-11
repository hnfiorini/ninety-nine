package com.ninetynine.backend.job;

import com.ninetynine.backend.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CompanyJob {

    @Autowired
    private CompanyService companyService;


    @Scheduled(initialDelay = 1000, fixedRate = 20000)
    public void updateCompanySharePrice() {
        System.out.println("Current time is :: " + LocalDateTime.now());

        companyService.updateSharePriceCompanies();

    }

//    @Scheduled(cron = "*/10 * * * * *")
//    public void updateCompanySharePrice2() {
//        System.out.println("Current time2 is :: " + LocalDate.now());
//    }

}
