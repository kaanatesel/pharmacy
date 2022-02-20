package com.pharmacy.api.mapper;

import org.mapstruct.Mapper;

import com.pharmacy.api.domain.Medicine;
import com.pharmacy.api.dto.CreateMedicineDto;
import com.pharmacy.api.dto.MedicineView;

@Mapper
public abstract class MedicineMapper {
	public abstract Medicine getMedicineFromCreateMedicineDto(CreateMedicineDto dto);

	public abstract MedicineView getMedicineViewFromMedicine(Medicine dto);
}
