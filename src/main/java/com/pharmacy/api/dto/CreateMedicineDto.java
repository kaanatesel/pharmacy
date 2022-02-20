package com.pharmacy.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CreateMedicineDto {
	@NotBlank
	String name;

	String desciption;

	@NotNull
	Integer companyId;
}
