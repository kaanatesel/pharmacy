package com.pharmacy.api.dto;

import java.util.Set;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CompanyView {
	@NotBlank
	String name;

	Set<MedicineView> medicines;
}