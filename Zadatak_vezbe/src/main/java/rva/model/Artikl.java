package rva.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Artikl implements Serializable {
	
private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ARTIKL_ID_GENERATOR")
	@SequenceGenerator(name="ARTIKL_ID_GENERATOR", sequenceName = "ARTIKL_SEQ", allocationSize = 1)
	private int id;
	
	private String naziv;
	
	private String proizvodjac;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}
	

}
