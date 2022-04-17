package com.example.weblink.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.weblink.modelo.Usuario;

public class UsuarioDto {
	private Long id;
	private String nome;
	private String cpfCnpj;
	private String email;
	private String cep;
	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private String numero;
	private Boolean cliente = false;
	private Boolean administrador = false;
	private Boolean conexao = false;
	
	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.cpfCnpj = usuario.getCpfCnpj();
		this.email = usuario.getEmail();
		this.cep = usuario.getCep();
		this.estado = usuario.getEstado();
		this.cidade = usuario.getCidade();
		this.bairro = usuario.getBairro();
		this.rua = usuario.getRua();
		this.numero = usuario.getNumero();
		this.cliente = usuario.getCliente();
		this.administrador = usuario.getAdministrador();
		this.conexao = usuario.getConexao();
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public String getEmail() {
		return email;
	}
	public String getCep() {
		return cep;
	}
	public String getEstado() {
		return estado;
	}
	public String getCidade() {
		return cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public String getRua() {
		return rua;
	}
	public String getNumero() {
		return numero;
	}
	public Boolean getCliente() {
		return cliente;
	}
	public Boolean getAdministrador() {
		return administrador;
	}
	public Boolean getConexao() {
		return conexao;
	}

	public static List<UsuarioDto> converter(List<Usuario> usuarios) {
		return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}
	
}
