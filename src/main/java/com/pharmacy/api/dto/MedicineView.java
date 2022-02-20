package com.pharmacy.api.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class MedicineView {
	@NotEmpty
	String name;

	String desciption;
}
