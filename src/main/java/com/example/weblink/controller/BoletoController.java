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

import com.example.weblink.controller.dto.BoletoDto;
import com.example.weblink.controller.form.BoletoForm;
import com.example.weblink.modelo.Boleto;
import com.example.weblink.repository.BoletoRepository;

@RestController
@RequestMapping("/boletos")
public class BoletoController {
	
	@Autowired
	private BoletoRepository boletoRepository;
	
	@GetMapping
	public List<BoletoDto> lista(Long idUsuario){
		if(idUsuario == null) {
			List<Boleto> boletos = (List<Boleto>) boletoRepository.findAll();
			return BoletoDto.converter(boletos);
		}else {
			List<Boleto> boletos = (List<Boleto>) boletoRepository.findByUsuarioId(idUsuario);
			return BoletoDto.converter(boletos);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<BoletoDto> cadastrar(@RequestBody @Valid BoletoForm boletoForm, UriComponentsBuilder uriBuilder) {
		Boleto boleto = boletoForm.converter();
		boletoRepository.save(boleto);
		
		URI uri = uriBuilder.path("/boleto/{id}").buildAndExpand(boleto.getId()).toUri();
		return ResponseEntity.created(uri).body(new BoletoDto(boleto));	
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BoletoDto> detalhar(@PathVariable Long id) {
		
		Optional<Boleto> boleto = boletoRepository.findById(id);
		if(boleto.isPresent()) {
			return ResponseEntity.ok(new BoletoDto(boleto.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<BoletoDto> atualizar(@PathVariable Long id, @RequestBody @Valid BoletoForm boletoForm){
		Optional<Boleto> optional = boletoRepository.findById(id);
		if(optional.isPresent()) {
			Boleto boleto = boletoForm.atualizar(id, boletoRepository);
			return ResponseEntity.ok(new BoletoDto(boleto));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Boleto> optional = boletoRepository.findById(id);
		if(optional.isPresent()) {
			boletoRepository.deleteById(id);
			
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
