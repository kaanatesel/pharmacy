package com.pharmacy.api.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "company")
public class Company {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	Integer id;

	@NotBlank
	String name;

	@OneToMany(mappedBy = "company")
	Set<Medicine> medicines = new HashSet<Medicine>();

	public void addMedicine(Medicine newMed) {
		medicines.add(newMed);
		newMed.setCompany(this);
	}

	public void removeMedicine(Medicine oldMed) {
		medicines.remove(oldMed);
	}
}
