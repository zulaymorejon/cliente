package com.cliente.api.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cliente.api.models.entity.Cliente;

public interface IClienteRepository extends PagingAndSortingRepository<Cliente, Long> {

}
