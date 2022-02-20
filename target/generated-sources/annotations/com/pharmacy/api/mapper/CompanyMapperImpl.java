package com.pharmacy.api.mapper;

import com.pharmacy.api.domain.Company;
import com.pharmacy.api.domain.Medicine;
import com.pharmacy.api.dto.CompanyDto;
import com.pharmacy.api.dto.CompanyView;
import com.pharmacy.api.dto.MedicineView;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-21T00:18:55+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15 (Oracle Corporation)"
)
@Component
public class CompanyMapperImpl extends CompanyMapper {

    @Override
    public CompanyView getCompanyViewFromCompany(Company dto) {
        if ( dto == null ) {
            return null;
        }

        CompanyView companyView = new CompanyView();

        companyView.setName( dto.getName() );
        companyView.setMedicines( medicineSetToMedicineViewSet( dto.getMedicines() ) );

        return companyView;
    }

    @Override
    public Company getCompanyFromCompanyDto(CompanyDto dto) {
        if ( dto == null ) {
            return null;
        }

        Company company = new Company();

        company.setName( dto.getName() );

        return company;
    }

    protected MedicineView medicineToMedicineView(Medicine medicine) {
        if ( medicine == null ) {
            return null;
        }

        MedicineView medicineView = new MedicineView();

        medicineView.setName( medicine.getName() );
        medicineView.setDesciption( medicine.getDesciption() );

        return medicineView;
    }

    protected Set<MedicineView> medicineSetToMedicineViewSet(Set<Medicine> set) {
        if ( set == null ) {
            return null;
        }

        Set<MedicineView> set1 = new HashSet<MedicineView>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Medicine medicine : set ) {
            set1.add( medicineToMedicineView( medicine ) );
        }

        return set1;
    }
}
