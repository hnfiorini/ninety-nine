package com.ninetynine.dataprovidermock.controller;

import com.ninetynine.dataprovidermock.entity.Company;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@RestController
public class DataProviderController {

    @GetMapping("/companies")
    public List<Company> findAllCompanies() {
        Random rand = new Random();
        int upperbound = 1000;
        Company company1 = Company.builder()
                .id("AMZN")
                .name("Amazon")
                .sharePrice(String.valueOf(rand.nextInt(upperbound)))
                .dateTime(LocalDateTime.now())
                .build();
        Company company2 = Company.builder()
                .id("MSFT")
                .name("Microsoft")
                .sharePrice(String.valueOf(rand.nextInt(upperbound)))
                .dateTime(LocalDateTime.now())
                .build();
        Company company3 = Company.builder()
                .id("GOOG")
                .name("Google")
                .sharePrice(String.valueOf(rand.nextInt(upperbound)))
                .dateTime(LocalDateTime.now())
                .build();
        System.out.println("COMPANY 1: " + company1);
        System.out.println("COMPANY 2: " + company2);
        System.out.println("COMPANY 3: " + company3);
        return List.of(company1, company2, company3);
    }
}
