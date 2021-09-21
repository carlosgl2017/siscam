package com.integrado.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integrado.entity.Disco;
import com.integrado.service.DiscoService;

@RestController
@RequestMapping("/disco")
public class DiscoController {
	@Autowired
	private DiscoService discoService;
	
	@GetMapping("/sel")
	public List<Disco> index() {
		return discoService.findAll();
	}
	
	@GetMapping("sel/{iddisco}")
	public ResponseEntity<?> show(@PathVariable Long iddisco) {
		
		Disco disco = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			disco = discoService.findById(iddisco);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(disco == null) {
			response.put("mensaje", "El dvr ID: ".concat(iddisco.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<Disco>(disco, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> create(@Valid @RequestBody Disco disco, BindingResult result) {
		
		Disco discoNew = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			discoNew = discoService.saveDisco(disco);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El disco ha sido creado con éxito!");
		response.put("disco", discoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/upd/{iddisco}")
	public ResponseEntity<?> update(@Valid @RequestBody Disco disco, BindingResult result, @PathVariable Long iddisco) {

		Disco discoActual = discoService.findById(iddisco);

		Disco discoUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (discoActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el disco ID: "
					.concat(iddisco.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			discoActual.setCapacidad(disco.getCapacidad());
			discoActual.setCodigoactivo(disco.getCodigoactivo());
			discoActual.setDescripcion(disco.getDescripcion());
			discoUpdated = discoService.saveDisco(discoActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el disco en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El disco ha sido actualizado con éxito!");
		response.put("disco", discoUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/del/{iddisco}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
					
		    discoService.deleteDiscoById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el disco de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El disco se ha eliminado con éxito!");		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
