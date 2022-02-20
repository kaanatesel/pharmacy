package com.pharmacy.api.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class CompanyDto {
	@NotEmpty
	String name; 
}
 