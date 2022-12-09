package com.ninetynine.backend.service;

import com.ninetynine.backend.entity.Company;
import com.ninetynine.backend.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> findAll() {
        List<Company> result = new ArrayList<Company>();
        companyRepository.findAll().forEach(result::add);
        return result;
    }

    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }
}
