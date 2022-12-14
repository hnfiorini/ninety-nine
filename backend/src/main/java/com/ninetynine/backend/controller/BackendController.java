package com.ninetynine.backend.controller;

import com.ninetynine.backend.dto.FilterDTO;
import com.ninetynine.backend.entity.Company;
import com.ninetynine.backend.entity.CompanyHistory;
import com.ninetynine.backend.exception.CompanyNotFoundException;
import com.ninetynine.backend.service.CompanyService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class BackendController {

    private CompanyService companyService;

    BackendController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/companies")
    public CollectionModel<EntityModel<Company>> findAllCompanies() {
        List<EntityModel<Company>> companies = companyService.findAll().stream()
                .map(company -> EntityModel.of(company,
                        linkTo(methodOn(BackendController.class).findCompanyById(company.getId())).withSelfRel(),
                        linkTo(methodOn(BackendController.class).findAllCompanies()).withRel("companies")))
                .collect(Collectors.toList());

        return CollectionModel.of(companies, linkTo(methodOn(BackendController.class).findAllCompanies()).withSelfRel());
    }

    @GetMapping("/companies/{id}")
    EntityModel<Company> findCompanyById(@PathVariable String id) {

        Company company = companyService.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException(id));

        return EntityModel.of(company,
                linkTo(methodOn(BackendController.class).findCompanyById(id)).withSelfRel(),
                linkTo(methodOn(BackendController.class).findAllCompanies()).withRel("companies"));
    }

    @GetMapping("/companies/{id}/history")
    List<CompanyHistory> findSharePriceCompanyWithFilters(@PathVariable String id,
                                                          @RequestParam String searchType,
                                                          @RequestParam(defaultValue = "0") int fromHour,
                                                          @RequestParam(defaultValue = "0") int toHour,
                                                          @RequestParam(defaultValue = "0") int day,
                                                          @RequestParam(defaultValue = "0") int month,
                                                          @RequestParam(defaultValue = "0") int year,
                                                          @RequestParam(defaultValue = "0") int fromDay,
                                                          @RequestParam(defaultValue = "0") int toDay
    ) {

        FilterDTO filterDTO = FilterDTO.builder()
                .idCompany(id)
                .searchType(searchType)
                .day(day)
                .fromDay(fromDay)
                .toDay(toDay)
                .fromHour(fromHour)
                .toHour(toHour)
                .month(month)
                .year(year)
                .build();
        List<CompanyHistory> historyList = companyService.findByFilter(filterDTO)
                .orElseThrow(() -> new CompanyNotFoundException(id));

        return historyList;
    }


}
