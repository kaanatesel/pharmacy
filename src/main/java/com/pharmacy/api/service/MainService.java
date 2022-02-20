package com.pharmacy.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.api.domain.Company;
import com.pharmacy.api.domain.Medicine;
import com.pharmacy.api.dto.CompanyDto;
import com.pharmacy.api.dto.CompanyView;
import com.pharmacy.api.dto.CreateMedicineDto;
import com.pharmacy.api.dto.MedicineView;
import com.pharmacy.api.error.NotFoundException;
import com.pharmacy.api.mapper.CompanyMapper;
import com.pharmacy.api.mapper.MedicineMapper;
import com.pharmacy.api.repository.CompanyRepository;
import com.pharmacy.api.repository.MedicineRepository;

@Service
public class MainService {

	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	CompanyMapper companyMapper;

	@Autowired
	MedicineRepository medicineRepository;

	@Autowired
	MedicineMapper medicineMapper;

	public CompanyView createCompany(CompanyDto dto) {
		Company company = companyMapper.getCompanyFromCompanyDto(dto);

		companyRepository.save(company);

		return companyMapper.getCompanyViewFromCompany(company);
	}

	public CompanyView getCompanyByName(Integer id) {
		Company company = companyRepository.findById(id).orElseThrow(() -> new NotFoundException("Company not found"));

		return companyMapper.getCompanyViewFromCompany(company);
	}

	public MedicineView createMedicine(CreateMedicineDto dto) {
		Medicine medicine = medicineMapper.getMedicineFromCreateMedicineDto(dto);

		Company company = companyRepository.findById(dto.getCompanyId())
				.orElseThrow(() -> new NotFoundException("Compnay not found"));

		company.addMedicine(medicine);

		Medicine medicinesaved = medicineRepository.save(medicine);

		return medicineMapper.getMedicineViewFromMedicine(medicinesaved);
	}

	public void deleteMedicineByName(Integer companyId, Integer medicineId) {

		try {
			Company company = companyRepository.findById(companyId)
					.orElseThrow(() -> new NotFoundException("Compnay not found"));

			Medicine med = medicineRepository.findById(medicineId)
					.orElseThrow(() -> new NotFoundException("Medicine not found"));

			company.removeMedicine(med);

			medicineRepository.deleteById(medicineId);

			companyRepository.save(company);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
