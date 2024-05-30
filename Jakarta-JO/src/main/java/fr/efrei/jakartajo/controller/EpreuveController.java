package fr.efrei.jakartajo.controller;

import fr.efrei.jakartajo.dto.CreateEpreuve;
import fr.efrei.jakartajo.dto.UpdateEpreuve;
import fr.efrei.jakartajo.model.Epreuve;
import fr.efrei.jakartajo.service.EpreuveService;
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
@RequestMapping("/api/epreuves")
public class EpreuveController {

	private final EpreuveService service;

	@Autowired
	public EpreuveController(EpreuveService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Epreuve>> findAll() {
		return new ResponseEntity<>(service.findAllEpreuves(), HttpStatus.OK);
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<Epreuve> findOneById(@PathVariable String uuid) {
		Epreuve epreuve = service.findEpreuveById(uuid);
		if (epreuve != null) {
			return new ResponseEntity<>(service.findEpreuveById(uuid), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Epreuve> save(@RequestBody CreateEpreuve epreuve) {
		Epreuve createdEpreuve = service.create(epreuve);
		return new ResponseEntity<>(createdEpreuve, HttpStatus.CREATED);
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
			@RequestBody UpdateEpreuve epreuve) {
		boolean isUpdated = service.update(uuid, epreuve);
		if (isUpdated) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PatchMapping("/{uuid}")
	public ResponseEntity<?> mettreAjourPartiellement(
			@PathVariable String uuid,
			@RequestBody UpdateEpreuve epreuve) {
		boolean isUpdated = service.updatePartielle(uuid, epreuve);
		if (isUpdated) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
