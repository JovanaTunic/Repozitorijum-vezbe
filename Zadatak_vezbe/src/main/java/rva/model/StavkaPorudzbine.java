package rva.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name="stavka_porudzbine")
public class StavkaPorudzbine implements Serializable{
private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STAVKA_PORUDZBINE_ID_GENERATOR")
	@SequenceGenerator(name="STAVKA_PORUDZBINE_ID_GENERATOR", sequenceName = "STAVKA_PORUDZBINE_SEQ", allocationSize = 1)
	private int id;
	
	@Column(name="redni_broj")
	private int redniBroj;
	
	private double kolicina;
	
	@Column(name="jedinica_mere")
	private String jedinicaMere;
	
	private double cena;
	
	@ManyToOne
	@JoinColumn(name="artikl")
	private Artikl artikl;
	
	@ManyToOne
	@JoinColumn(name="porudzbina")
	private Porudzbina porudzbina;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRedniBroj() {
		return redniBroj;
	}

	public void setRedniBroj(int redniBroj) {
		this.redniBroj = redniBroj;
	}

	public double getKolicina() {
		return kolicina;
	}

	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}

	public String getJedinicaMere() {
		return jedinicaMere;
	}

	public void setJedinicaMere(String jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Artikl getArtikl() {
		return artikl;
	}

	public void setArtikl(Artikl artikl) {
		this.artikl = artikl;
	}

	public Porudzbina getPorudzbina() {
		return porudzbina;
	}

	public void setPorudzbina(Porudzbina porudzbina) {
		this.porudzbina = porudzbina;
	}
	
	
	
}
