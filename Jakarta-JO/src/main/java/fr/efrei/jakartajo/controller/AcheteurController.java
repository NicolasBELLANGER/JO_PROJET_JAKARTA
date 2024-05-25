package fr.efrei.jakartajo.controller;

import fr.efrei.jakartajo.dto.CreateAcheteur;
import fr.efrei.jakartajo.dto.UpdateAcheteur;
import fr.efrei.jakartajo.model.Acheteur;
import fr.efrei.jakartajo.service.AcheteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/acheteurs")
public class AcheteurController {

	private final AcheteurService service;

	@Autowired
	public AcheteurController(AcheteurService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Acheteur>> findAll() {
		return new ResponseEntity<>(service.findAllAcheteurs(), HttpStatus.OK);
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<Acheteur> findOneById(@PathVariable String uuid) {
		Acheteur acheteur = service.findAcheteurById(uuid);
		if (acheteur != null) {
			return new ResponseEntity<>(service.findAcheteurById(uuid), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Acheteur> save(@RequestBody CreateAcheteur acheteur) {
		Acheteur createdAcheteur = service.create(acheteur);
		return new ResponseEntity<>(createdAcheteur, HttpStatus.CREATED);
	}

	@DeleteMapping("/{uuid}")
	public ResponseEntity<?> delete(@PathVariable String uuid) {
		boolean isDeleted = service.delete(uuid);
		if (isDeleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{uuid}")
	public ResponseEntity<?> mettreAJourTotalement(
			@PathVariable String uuid,
			@RequestBody UpdateAcheteur acheteur) {
		boolean isUpdated = service.update(uuid, acheteur);
		if (isUpdated) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PatchMapping("/{uuid}")
	public ResponseEntity<?> mettreAjourPartiellement(
			@PathVariable String uuid,
			@RequestBody UpdateAcheteur acheteur) {
		boolean isUpdated = service.updatePartielle(uuid, acheteur);
		if (isUpdated) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
