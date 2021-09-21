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

import com.integrado.entity.DetalleRotacion;
import com.integrado.service.DetalleRotacionService;

@RestController
@RequestMapping("/detallerotacion")
public class DetalleRotacionController {

	@Autowired
	private DetalleRotacionService detalleRotacionService;
	
	@GetMapping("/sel")
	public List<DetalleRotacion> index() {
		return detalleRotacionService.findAll();
	}
	
	@GetMapping("sel/{iddetallerotacion}")
	public ResponseEntity<?> show(@PathVariable Long iddetallerotacion) {
		
		DetalleRotacion detallerotacion = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			detallerotacion = detalleRotacionService.findById(iddetallerotacion);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(detallerotacion == null) {
			response.put("mensaje", "El dvr ID: ".concat(iddetallerotacion.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<DetalleRotacion>(detallerotacion, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> create(@Valid @RequestBody DetalleRotacion detalleRotacion, BindingResult result) {
		
		DetalleRotacion detalleRotacionNew = null;
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
			detalleRotacionNew = detalleRotacionService.saveDetalleRotacion(detalleRotacion);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El detalle de la rotacion ha sido creado con éxito!");
		response.put("detalle rotacion", detalleRotacionNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/upd/{iddetallerotacion}")
	public ResponseEntity<?> update(@Valid @RequestBody DetalleRotacion detalleRotacion, BindingResult result, @PathVariable Long iddetallerotacion) {

		DetalleRotacion detalleRotacionActual = detalleRotacionService.findById(iddetallerotacion);

		DetalleRotacion detalleRotacionUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (detalleRotacionActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el disco ID: "
					.concat(iddetallerotacion.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			detalleRotacionActual.setDisco(detalleRotacion.getDisco());
			detalleRotacionUpdated = detalleRotacionService.saveDetalleRotacion(detalleRotacionActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el disco en la base de datos");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El detalle rotacion ha sido actualizado con éxito!");
		response.put("detalle rotacion", detalleRotacionUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/del/{iddetallerotacion}")
	public ResponseEntity<?> delete(@PathVariable Long iddetallerotacion) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
					
		    detalleRotacionService.deleteDetalleRotacionById(iddetallerotacion);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el detalle de la rotacion de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El detalle de la rotacion se ha eliminado con éxito!");		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
