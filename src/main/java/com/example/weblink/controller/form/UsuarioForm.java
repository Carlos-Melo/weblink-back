package com.example.weblink.controller.form;

import javax.validation.constraints.NotNull;

import com.example.weblink.modelo.Plano;
import com.example.weblink.modelo.Usuario;

public class UsuarioForm {
	
	private String nome;
	@NotNull
	private String cpfCnpj;
	@NotNull
	private String email;
	@NotNull
	private String senha;
	private String cep;
	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private String numero;
	private Boolean cliente = false;
	private Boolean administrador = false;
	private Boolean conexao = false;
	private Plano plano;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Boolean getCliente() {
		return cliente;
	}
	public void setCliente(Boolean cliente) {
		this.cliente = cliente;
	}
	public Boolean getAdministrador() {
		return administrador;
	}
	public void setAdministrador(Boolean administrador) {
		this.administrador = administrador;
	}
	public Boolean getConexao() {
		return conexao;
	}
	public void setConexao(Boolean conexao) {
		this.conexao = conexao;
	}
	public Plano getPlano() {
		return plano;
	}
	public void setPlano(Plano plano) {
		this.plano = plano;
	}
	
	public Usuario converter() {
		return new Usuario(nome, cpfCnpj, email, senha, cep, estado, cidade, bairro, rua, numero, cliente, administrador, conexao, plano);
	}
	
}
