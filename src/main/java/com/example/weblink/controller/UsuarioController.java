package com.example.weblink.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.weblink.controller.dto.DetalhesDoUsuarioDto;
import com.example.weblink.controller.dto.UsuarioDto;
import com.example.weblink.controller.form.AtualizacaoUsuarioForm;
import com.example.weblink.controller.form.UsuarioForm;
import com.example.weblink.modelo.Usuario;
import com.example.weblink.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public List<UsuarioDto> lista(String emailUsuario){
		if(emailUsuario == null) {
			List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
			return UsuarioDto.converter(usuarios);
		}else {
			List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findByEmail(emailUsuario);
			return UsuarioDto.converter(usuarios);
		}
		
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioForm usuarioForm, UriComponentsBuilder uriBuilder) {
		List<Usuario> usuarioEmailList = usuarioRepository.findByEmail(usuarioForm.getEmail());
		if(usuarioEmailList.isEmpty()) {
			List<Usuario> usuarioCpfList = usuarioRepository.findByCpfCnpj(usuarioForm.getCpfCnpj());
			if(usuarioCpfList.isEmpty()) {
				Usuario usuario = usuarioForm.converter();
				usuarioRepository.save(usuario);
				
				URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
				return ResponseEntity.created(uri).body(new UsuarioDto(usuario));	
			}	
		}
		return ResponseEntity.badRequest().body(null);
		
	}
	
	@GetMapping("/{cpfCnpj}")
	public ResponseEntity<DetalhesDoUsuarioDto> detalhar(@PathVariable String cpfCnpj) {
		
		List<Usuario> usuario = usuarioRepository.findByCpfCnpj(cpfCnpj);
		if(!usuario.isEmpty()) {
			return ResponseEntity.ok(new DetalhesDoUsuarioDto(usuario.get(0)));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<UsuarioDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoUsuarioForm usuarioForm){
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if(optional.isPresent()) {
			Usuario usuario = usuarioForm.atualizar(id, usuarioRepository);
			return ResponseEntity.ok(new UsuarioDto(usuario));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if(optional.isPresent()) {
			usuarioRepository.deleteById(id);
			
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
}
