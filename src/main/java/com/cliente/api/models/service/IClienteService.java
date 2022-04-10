package com.cliente.api.models.service;

import java.util.List;

import com.cliente.api.models.entity.Cliente;

public interface IClienteService {
	List<Cliente> findAll();
	Cliente save(Cliente cliente);
	Cliente findById(Long id);
	void deleteById(Long id);
}
