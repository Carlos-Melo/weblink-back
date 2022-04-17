package com.example.weblink.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.weblink.modelo.Boleto;

public interface BoletoRepository extends CrudRepository<Boleto, Long>{
	Optional<Boleto> findById(Long	 id);

	Boleto findById(long id);

	Boleto getOne(Long id);

	List<Boleto> findByUsuarioId(Long idUsuario);
	
}
