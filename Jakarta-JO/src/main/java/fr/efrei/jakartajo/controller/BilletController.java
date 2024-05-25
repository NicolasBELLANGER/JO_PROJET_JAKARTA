package fr.efrei.jakartajo.controller;

import fr.efrei.jakartajo.dto.CreateBillet;
import fr.efrei.jakartajo.dto.UpdateBillet;
import fr.efrei.jakartajo.model.Billet;
import fr.efrei.jakartajo.service.BilletService;
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
@RequestMapping("/billets")
public class BilletController {

	private final BilletService service;

	@Autowired
	public BilletController(BilletService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Billet>> findAll() {
		return new ResponseEntity<>(service.findAllBillets(), HttpStatus.OK);
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<Billet> findOneById(@PathVariable String uuid) {
		Billet billet = service.findBilletById(uuid);
		if (billet != null) {
			return new ResponseEntity<>(service.findBilletById(uuid), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Billet> save(@RequestBody CreateBillet billet) {
		Billet createdBillet = service.create(billet);
		return new ResponseEntity<>(createdBillet, HttpStatus.CREATED);
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
			@RequestBody UpdateBillet billet) {
		boolean isUpdated = service.update(uuid, billet);
		if (isUpdated) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PatchMapping("/{uuid}")
	public ResponseEntity<?> mettreAjourPartiellement(
			@PathVariable String uuid,
			@RequestBody UpdateBillet billet) {
		boolean isUpdated = service.updatePartielle(uuid, billet);
		if (isUpdated) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
