package com.info.differenziata.controller;

import com.info.differenziata.model.dto.BaseDto;
import com.info.differenziata.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public abstract class BaseController<S extends BaseService, T extends BaseDto> {
	@Autowired
	private S service;

	public static <X> ResponseEntity<X> wrapOrNotFound(Optional<X> maybeResponse) {
		return maybeResponse.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	public S getService() {
		return service;
	}

	@PostMapping()
	public ResponseEntity<Long> create(@RequestBody T dto) {
		if (dto.getId() != null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		return (ResponseEntity<Long>) getService().create(dto).map(id -> ResponseEntity.ok().body(id))
				.orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
	}

	@GetMapping("{id}")
	public ResponseEntity<T> getById(@PathVariable Long id) {
		return wrapOrNotFound(getService().getById(id));
	}

	@GetMapping()
	public ResponseEntity<List<T>> findall() {
		return ResponseEntity.ok(getService().findAll());
	}

	@PutMapping("{id}")
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody T dto) {
		if (dto.getId() == null || !dto.getId().equals(id))
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		getService().update(dto);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<T> deleteById(@PathVariable Long id) {
		return wrapOrNotFound(getService().deleteById(id));
	}
}
