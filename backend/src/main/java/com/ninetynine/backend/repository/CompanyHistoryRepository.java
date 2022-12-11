package com.ninetynine.backend.repository;

import com.ninetynine.backend.entity.CompanyHistory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyHistoryRepository extends CrudRepository<CompanyHistory, Long> {

    List<CompanyHistory> findByCompanyId(String idCompany);
}
