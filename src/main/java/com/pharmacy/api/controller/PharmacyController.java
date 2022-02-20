package com.pharmacy.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacy.api.dto.CompanyDto;
import com.pharmacy.api.dto.CompanyView;
import com.pharmacy.api.dto.CreateMedicineDto;
import com.pharmacy.api.dto.MedicineView;
import com.pharmacy.api.service.MainService;

@RestController
@RequestMapping("api/pharmacy/")
public class PharmacyController {

	@Autowired
	MainService service;

	@GetMapping("getcompany/{id}")
	public ResponseEntity<CompanyView> getCompany(@PathVariable(name = "id", required = true) Integer id) {
		return ResponseEntity.ok().body(service.getCompanyByName(id));
	}

	@PostMapping("createCompany/")
	public ResponseEntity<CompanyView> createCompany(@RequestBody @Valid CompanyDto dto) {
		return ResponseEntity.ok().body(service.createCompany(dto));
	}

	@PostMapping("createMedicine/")
	public ResponseEntity<MedicineView> createMedicine(@RequestBody @Valid CreateMedicineDto dto) {
		MedicineView view = service.createMedicine(dto);
		return ResponseEntity.ok().body(view); 
	}

	@DeleteMapping("deletemedicine/{companyId}/{medId}")
	public ResponseEntity<Void> deleteMedicine(@PathVariable(name = "companyId", required = true) Integer companyId,
			@PathVariable(name = "medId", required = true) Integer medId) {
		service.deleteMedicineByName(companyId, medId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
