package com.pharmacy.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
@Table(name = "medicine")
public class Medicine{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	Integer id; 
	
	@NotBlank
	String name;

	String desciption;
	
	@ManyToOne(fetch = FetchType.LAZY)
    private Company company;
	
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medicine )) return false;
        return id != null && id.equals(((Medicine) o).getId());
    }
 
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
