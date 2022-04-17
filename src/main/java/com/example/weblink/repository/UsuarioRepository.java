package com.example.weblink.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.weblink.modelo.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
		Optional<Usuario> findById(Long	 id);

	    Usuario findById(long id);

		List<Usuario> findByEmail(String emailUsuario);

		Usuario getOne(Long id);
		
		List<Usuario> findByCpfCnpj(String cpfCnpjUsuario);
}
