package com.pharmacy.api.mapper;

import org.mapstruct.Mapper;

import com.pharmacy.api.domain.Company;
import com.pharmacy.api.dto.CompanyDto;
import com.pharmacy.api.dto.CompanyView;

@Mapper
public abstract class CompanyMapper {

	public abstract CompanyView getCompanyViewFromCompany(Company dto);

	public abstract Company getCompanyFromCompanyDto(CompanyDto dto);
}
