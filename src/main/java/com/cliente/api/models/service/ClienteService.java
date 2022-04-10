package com.cliente.api.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cliente.api.models.entity.Cliente;
import com.cliente.api.models.repository.IClienteRepository;

//@Service
public class ClienteService implements IClienteService {

	@Autowired
	private IClienteRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll(){
		return (List<Cliente>) repository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return repository.save(cliente);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
