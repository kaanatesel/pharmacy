package com.pharmacy.api.mapper;

import com.pharmacy.api.domain.Medicine;
import com.pharmacy.api.dto.CreateMedicineDto;
import com.pharmacy.api.dto.MedicineView;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-21T00:18:54+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15 (Oracle Corporation)"
)
@Component
public class MedicineMapperImpl extends MedicineMapper {

    @Override
    public Medicine getMedicineFromCreateMedicineDto(CreateMedicineDto dto) {
        if ( dto == null ) {
            return null;
        }

        Medicine medicine = new Medicine();

        medicine.setName( dto.getName() );
        medicine.setDesciption( dto.getDesciption() );

        return medicine;
    }

    @Override
    public MedicineView getMedicineViewFromMedicine(Medicine dto) {
        if ( dto == null ) {
            return null;
        }

        MedicineView medicineView = new MedicineView();

        medicineView.setName( dto.getName() );
        medicineView.setDesciption( dto.getDesciption() );

        return medicineView;
    }
}
