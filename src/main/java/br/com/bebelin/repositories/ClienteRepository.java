package br.com.bebelin.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.bebelin.models.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer>{

}
