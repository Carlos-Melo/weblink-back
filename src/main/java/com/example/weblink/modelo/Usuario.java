package com.example.weblink.modelo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Usuario {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpfCnpj;
	private String email;
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
	@ManyToOne
	private Plano plano;
	
	public Usuario() {
	}
	
	public Usuario(String nome, String cpfCnpj, String email, String senha, String cep, String estado, String cidade,
			String bairro, String rua, String numero, Boolean cliente, Boolean administrador, Boolean conexao, Plano plano) {
		super();
		this.nome = nome;
		this.cpfCnpj = cpfCnpj;
		this.email = email;
		this.senha = senha;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.cliente = cliente;
		this.administrador = administrador;
		this.conexao = conexao;
		this.plano = plano;
	}


	@Override
	public int hashCode() {
		return Objects.hash(administrador, bairro, cep, cidade, cliente, cpfCnpj, email, estado, id, nome, numero,
				plano, rua, senha, conexao);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(administrador, other.administrador) && Objects.equals(bairro, other.bairro)
				&& Objects.equals(cep, other.cep) && Objects.equals(cidade, other.cidade)
				&& Objects.equals(cliente, other.cliente) && Objects.equals(cpfCnpj, other.cpfCnpj)
				&& Objects.equals(email, other.email) && Objects.equals(estado, other.estado)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(numero, other.numero) && Objects.equals(plano, other.plano)
				&& Objects.equals(rua, other.rua) && Objects.equals(senha, other.senha)
				&& Objects.equals(conexao, other.conexao);
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	
}
