package rva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rva.model.Artikl;

public interface ArtiklRepository extends JpaRepository<Artikl,Integer>{
	
	//Drugi parametar je tip podatka primarnog kljuca
	
	List<Artikl> findByNazivContainingIgnoreCase(String naziv);   
	//containing - da deo koji korisnik trazi bude deo naziva
	//ignoreCase - da ignorise velika i mala slova- da korisnik moze da unese bilo sta
	
   /* 1. NACIN
    * @Query(value="select * from artikl where lower(naziv) like ?1%",nativeQuery=true)   //?1 pristupanje parametru metode getArtikliByPocetakNaziva
	List<Artikl> getArtikliByPocetakNaziva(String pocetakNaziva);*/
	
	//2.NACIN
    @Query(value="select * from artikl where lower(naziv) like ?1%",nativeQuery=true)   
	List<Artikl> getArtikliByPocetakNaziva(@Param("pocetak")String pocetakNaziva);
}

