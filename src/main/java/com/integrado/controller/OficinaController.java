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

import com.integrado.entity.Oficina;
import com.integrado.service.OficinaService;

@RestController
@RequestMapping("/oficina")
public class OficinaController {

	@Autowired
	private OficinaService oficinaService;
	
	@GetMapping("/sel")
	public List<Oficina> index() {
		return oficinaService.findAll();
	}
	
	@GetMapping("sel/{idoficina}")
	public ResponseEntity<?> show(@PathVariable Long idoficina) {
		
		Oficina oficina = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			oficina = oficinaService.findById(idoficina);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(oficina == null) {
			response.put("mensaje", "La Oficina ID: ".concat(idoficina.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<Oficina>(oficina, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> create(@Valid @RequestBody Oficina oficina, BindingResult result) {
		
		Oficina oficinaNew = null;
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
			oficinaNew = oficinaService.saveOficina(oficina);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La oficina ha sido creado con éxito!");
		response.put("disco", oficinaNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/upd/{idoficina}")
	public ResponseEntity<?> update(@Valid @RequestBody Oficina oficina, BindingResult result, @PathVariable Long idoficina) {

		Oficina oficinaActual = oficinaService.findById(idoficina);

		Oficina oficinaUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (oficinaActual == null) {
			response.put("mensaje", "Error: no se pudo editar, la oficina ID: "
					.concat(idoficina.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			oficinaActual.setDescripcion(oficina.getDescripcion());
			oficinaActual.setOficina(oficina.getOficina());
			
			oficinaUpdated = oficinaService.saveOficina(oficinaActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la oficina en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La oficina ha sido actualizado con éxito!");
		response.put("oficina", oficinaUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/del/{idoficina}")
	public ResponseEntity<?> delete(@PathVariable Long idoficina) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
					
		    oficinaService.deleteOficinaById(idoficina);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la oficina de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La oficina se ha eliminado con éxito!");		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
