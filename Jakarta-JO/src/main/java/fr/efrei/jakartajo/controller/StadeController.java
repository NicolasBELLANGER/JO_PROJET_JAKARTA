package fr.efrei.jakartajo.controller;

import fr.efrei.jakartajo.dto.CreateStade;
import fr.efrei.jakartajo.dto.UpdateStade;
import fr.efrei.jakartajo.model.Stade;
import fr.efrei.jakartajo.service.StadeService;

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
@RequestMapping("/stades")
public class StadeController {

	private final StadeService service;

	@Autowired
	public StadeController(StadeService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Stade>> findAll() {
		return new ResponseEntity<>(service.findAllStades(), HttpStatus.OK);
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<Stade> findOneById(@PathVariable String uuid) {
		Stade stade = service.findStadeById(uuid);
		if (stade != null) {
			return new ResponseEntity<>(service.findStadeById(uuid), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Stade> save(@RequestBody CreateStade stade) {
		Stade createdStade = service.create(stade);
		return new ResponseEntity<>(createdStade, HttpStatus.CREATED);
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
			@RequestBody UpdateStade stade) {
		boolean isUpdated = service.update(uuid, stade);
		if (isUpdated) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PatchMapping("/{uuid}")
	public ResponseEntity<?> mettreAjourPartiellement(
			@PathVariable String uuid,
			@RequestBody UpdateStade stade) {
		boolean isUpdated = service.updatePartielle(uuid, stade);
		if (isUpdated) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
