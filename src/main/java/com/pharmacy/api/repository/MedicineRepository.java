package com.pharmacy.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.pharmacy.api.domain.Medicine;

public interface MedicineRepository extends CrudRepository<Medicine, Integer> {

}
