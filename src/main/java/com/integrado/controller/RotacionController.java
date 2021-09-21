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
import com.integrado.entity.Rotacion;
import com.integrado.service.DiscoService;
import com.integrado.service.RotacionService;

@RestController
@RequestMapping("/rotacion")
public class RotacionController {
	@Autowired
	private RotacionService rotacionService;
	
	@GetMapping("/sel")
	public List<Rotacion> index() {
		return rotacionService.findAll();
	}
	
	@GetMapping("sel/{idrotacion}")
	public ResponseEntity<?> show(@PathVariable Long idrotacion) {
		
		Rotacion rotacion = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			rotacion = rotacionService.findById(idrotacion);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(rotacion == null) {
			response.put("mensaje", "El rotacion ID: ".concat(idrotacion.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<Rotacion>(rotacion, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> create(@Valid @RequestBody Rotacion rotacion, BindingResult result) {
		
		Rotacion rotacionNew = null;
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
			rotacionNew = rotacionService.saveRotacion(rotacion);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La rotacion ha sido creado con éxito!");
		response.put("disco", rotacionNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/upd/{idrotacion}")
	public ResponseEntity<?> update(@Valid @RequestBody Rotacion rotacion, BindingResult result, @PathVariable Long idrotacion) {

		Rotacion rotacionActual = rotacionService.findById(idrotacion);

		Rotacion rotacionUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (rotacionActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el disco ID: "
					.concat(idrotacion.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			rotacionActual.setFechahoracambio(rotacion.getFechahoracambio());
			rotacionActual.setFechaini(rotacion.getFechaini());
			rotacionActual.setFechafin(rotacion.getFechafin());
			rotacionActual.setObservacion(rotacion.getObservacion());
			rotacionUpdated = rotacionService.saveRotacion(rotacionActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la rotacion en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La rotacion ha sido actualizado con éxito!");
		response.put("disco", rotacionUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/del/{idrotacion}")
	public ResponseEntity<?> delete(@PathVariable Long idrotacion) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
					
		    rotacionService.deleteRotacionById(idrotacion);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la rotacion de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La rotacion se ha eliminado con éxito!");		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
