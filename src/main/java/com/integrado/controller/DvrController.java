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

import com.integrado.entity.Dvr;
import com.integrado.service.DvrService;

@RestController
@RequestMapping("/dvr")
public class DvrController {
	@Autowired
	private DvrService dvrService;
	
	@GetMapping("/sel")
	public List<Dvr> index() {
		return dvrService.findAll();
	}
	
	@GetMapping("sel/{iddvr}")
	public ResponseEntity<?> show(@PathVariable Long iddvr) {
		
		Dvr dvr = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			dvr = dvrService.findById(iddvr);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(dvr == null) {
			response.put("mensaje", "El dvr ID: ".concat(iddvr.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<Dvr>(dvr, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> create(@Valid @RequestBody Dvr dvr, BindingResult result) {
		
		Dvr dvrNew = null;
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
			dvrNew = dvrService.saveDvr(dvr);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El dvr ha sido creado con éxito!");
		response.put("cliente", dvrNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/upd/{iddvr}")
	public ResponseEntity<?> update(@Valid @RequestBody Dvr dvr, BindingResult result, @PathVariable Long iddvr) {

		Dvr dvrActual = dvrService.findById(iddvr);

		Dvr dvrUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (dvrActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el dvr ID: "
					.concat(iddvr.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			dvrActual.setCodigoactivo(dvr.getCodigoactivo());
			dvrActual.setDescripcion(dvr.getDescripcion());
			dvrActual.setMarca(dvr.getMarca());
			dvrActual.setModelo(dvr.getModelo());

			dvrUpdated = dvrService.saveDvr(dvrActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la categoria en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El dvr ha sido actualizado con éxito!");
		response.put("dvr", dvrUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/del/{iddvr}")
	public ResponseEntity<?> delete(@PathVariable Long iddvr) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
					
		    dvrService.deleteDvrById(iddvr);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el dvr de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El dvr se ha eliminado con éxito!");		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
