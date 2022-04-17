package com.example.weblink.modelo;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Boleto {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dtPagamento;
	private Boolean isPago;
	@ManyToOne
	private Usuario usuario;
	
	public Boleto() {
	}
	
	public Boleto(Date dtPagamento, Boolean isPago, Usuario usuario) {
		super();
		this.dtPagamento = dtPagamento;
		this.isPago = isPago;
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dtPagamento, id, isPago, usuario);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Boleto other = (Boleto) obj;
		return Objects.equals(dtPagamento, other.dtPagamento) && Objects.equals(id, other.id)
				&& Objects.equals(usuario, other.usuario) && Objects.equals(isPago, other.isPago);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDtPagamento() {
		return dtPagamento;
	}
	public void setDtPagamento(Date dtPagamento) {
		this.dtPagamento = dtPagamento;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Boolean getIsPago() {
		return isPago;
	}
	public void setIsPago(Boolean isPago) {
		this.isPago = isPago;
	}
	
}
