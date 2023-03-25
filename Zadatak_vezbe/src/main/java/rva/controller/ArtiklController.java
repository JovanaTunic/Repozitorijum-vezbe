package rva.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import rva.model.Artikl;
import rva.service.ArtiklService;

@RestController
public class ArtiklController {
	
	@Autowired
	private ArtiklService artiklService;
	
	/*@GetMapping("/artikl")  // da mapira get metodu
    public List<Artikl> getAllArtikli()                                  *****Ranija verzijaaa******
	{
    	 return artiklService.getAllArtikli();
	}*/
	
	@GetMapping("/artikl")  // da mapira get metodu
    public ResponseEntity<?> getAllArtikli()
	{
		 List<Artikl> artikli = artiklService.getAllArtikli();
		 
		 if(artikli.isEmpty()) {
			 return new ResponseEntity<>("artikli - empty list",HttpStatus.NOT_FOUND);
		 }
    	 return new ResponseEntity<>(artikli,HttpStatus.OK);
	}
	
	/*@GetMapping("/artikl/{id}")  // da mapira get metode
    public Optional <Artikl> getArtiklByID(@PathVariable("id")int artiklId)   *****Ranije verzije*****
	{
    	 return artiklService.getArtiklByID(artiklId);
	}*/
	
	@GetMapping("/artikl/{id}")  // da mapira get metodu
    public ResponseEntity<?> getArtiklByID(@PathVariable("id")int artiklId)
	{
		if(artiklService.existsById(artiklId)) {
			Optional<Artikl> artikl = artiklService.getArtiklByID(artiklId);
		    return ResponseEntity.ok(artikl);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Artikl by id" + artiklId + "not found");
	}

	@GetMapping("/artikl/naziv/{naziv}")  // da mapira get metodu
    public ResponseEntity<?> getAllArtikliByNaziv(@PathVariable("naziv")String naziv)  //mora path variable
	{
		 List<Artikl> artikli = artiklService.getAllArtikliByNaziv(naziv);
		 
		 if(artikli.isEmpty()) {
			 return new ResponseEntity<>("artikli - empty list",HttpStatus.NOT_FOUND);
		 }
    	 return new ResponseEntity<>(artikli,HttpStatus.OK);
	}
	
	@GetMapping("/artikl/pocetakNaziva/{pocetakNaziva}")  // da mapira get metodu
    public ResponseEntity<?> getAllArtikliByPocetakNaziva(@PathVariable("pocetakNaziva")String pocetakNaziva)  //mora path variable
	{
		 List<Artikl> artikli = artiklService.getAllArtikliByPocetakNaziva(pocetakNaziva);
		 
		 if(artikli.isEmpty()) {
			 return new ResponseEntity<>("artikli - empty list",HttpStatus.NOT_FOUND);
		 }
    	 return new ResponseEntity<>(artikli,HttpStatus.OK);
	}
	
}
