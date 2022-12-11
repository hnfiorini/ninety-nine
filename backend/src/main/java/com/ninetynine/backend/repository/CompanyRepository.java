package com.ninetynine.backend.repository;

import com.ninetynine.backend.entity.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, String> {
}
