package com.ninetynine.backend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ninetynine.backend.dto.CompanyDTO;
import com.ninetynine.backend.dto.FilterDTO;
import com.ninetynine.backend.entity.Company;
import com.ninetynine.backend.entity.CompanyHistory;
import com.ninetynine.backend.enums.SearchTypeEnum;
import com.ninetynine.backend.repository.CompanyHistoryRepository;
import com.ninetynine.backend.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CompanyHistoryRepository companyHistoryRepository;

    public List<Company> findAll() {
        List<Company> result = new ArrayList<Company>();
        companyRepository.findAll().forEach(result::add);
        return result;
    }

    public Optional<Company> findById(String id) {
        return companyRepository.findById(id);
    }


    public void updateSharePriceCompanies() {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        //TODO make this URL configurable
        JsonNode responseEntity =
                new RestTemplate().getForObject("http://localhost:8081/companies", JsonNode.class);

        List<CompanyDTO> companyList = mapper.convertValue(
                responseEntity,
                new TypeReference<List<CompanyDTO>>(){}
        );

        companyList.forEach(c -> {
            Optional<Company> company = companyRepository.findById(c.getId());
            if (company.isEmpty()) {
                companyRepository.save(new Company(c.getId(), c.getName()));
            }
            companyHistoryRepository.save(new CompanyHistory(new Company(c.getId(), c.getName()), c.getSharePrice(), c.getDateTime()));

        });

    }

    public Optional<List<CompanyHistory>> findByFilter(FilterDTO filterDTO) {
        if (filterDTO.getSearchType().equals(SearchTypeEnum.DAILY.name())) {
            //TODO create custom query
        }
        if (filterDTO.getSearchType().equals(SearchTypeEnum.HOURLY.name())) {
            //TODO create custom query
        }
        return Optional.of(companyHistoryRepository.findByCompanyId(filterDTO.getIdCompany()));
    }
}
