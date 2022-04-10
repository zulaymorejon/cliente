package com.cliente.api.controller;

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

import com.cliente.api.models.entity.Cliente;
import com.cliente.api.models.service.IClienteService;

@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	private IClienteService service;
	
	@GetMapping("/clientes")
	public List<Cliente> listarCliente(){
		return service.findAll();
	}
	
	@PostMapping("/clientes")
	public ResponseEntity<?> guardarEmpleado(@Valid @RequestBody Cliente cliente, BindingResult result){
		Cliente clienteObj = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			List<String> resultError = result.getFieldErrors().stream().map(r-> "El campo '"+r.getField()+"' "+r.getDefaultMessage()).collect(Collectors.toList());
			response.put("error", resultError);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
		}
		
		try {
			clienteObj = service.save(cliente);
		} catch (DataAccessException e) {
			response.put("error", e.getMostSpecificCause().getMessage());
			response.put("mensaje", "Se produjo un error en la aplicacion");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Cliente creado con exito.");
		response.put("cliente", clienteObj);
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	
	@PutMapping("/clientes/{id}")
	public ResponseEntity<?> actualizarEmpleado(@Valid @RequestBody Cliente cliente, BindingResult result, @PathVariable Long id){
		Cliente clienteFinal = null;
		Map<String, Object> response = new HashMap<>();
		Cliente clienteObj = service.findById(id);
		
		if(result.hasErrors()) {
			List<String> resultError = result.getFieldErrors().stream().map(r-> "El campo '"+r.getField()+"' "+r.getDefaultMessage()).collect(Collectors.toList());
			response.put("erros", resultError);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
		}
		
		if(clienteObj == null) {
			response.put("mensaje", "No existe el cliente con el id "+id);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			
			
			clienteObj.setIdentificacion(cliente.getIdentificacion());
			clienteObj.setNombre(cliente.getNombre());
			clienteObj.setEdad(cliente.getEdad());
			clienteObj.setGenero(cliente.getGenero());
			clienteObj.setDireccion(cliente.getDireccion());
			clienteObj.setTelefono(cliente.getTelefono());
			clienteObj.setPassword(cliente.getPassword());
			clienteObj.setEstado(cliente.getEstado());
				
			clienteFinal = service.save(clienteObj);
			
		} catch (DataAccessException e) {
			response.put("error", e.getMostSpecificCause().getMessage());
			response.put("mensaje", "Se produjo un error en la aplicacion");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Cliente actualizado con exito.");
		response.put("cliente", clienteFinal);
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/cuentas/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		Map<String, Object> response = new HashMap<>();
		try {
			service.deleteById(id);
		} catch (DataAccessException e) {
			response.put("error", e.getMostSpecificCause().getMessage());
			response.put("mensaje", "Se produjo un error en la aplicacion");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Cliente eliminado con exito.");
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
		
	}
}
