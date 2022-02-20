package com.pharmacy.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.pharmacy.api.domain.Company;

public interface CompanyRepository extends CrudRepository<Company, Integer> {

}
