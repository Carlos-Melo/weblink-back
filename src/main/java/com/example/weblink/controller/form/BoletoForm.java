package com.example.weblink.controller.form;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import com.example.weblink.modelo.Boleto;
import com.example.weblink.modelo.Usuario;
import com.example.weblink.repository.BoletoRepository;

public class BoletoForm {
	
	@NotNull
	private Date dtPagamento;
	private Boolean isPago;
	@NotNull
	private Usuario usuario;
	
	public Date getDtPagamento() {
		return dtPagamento;
	}
	public void setDtPagamento(Date dtPagamento) {
		this.dtPagamento = dtPagamento;
	}
	public Boolean getIsPago() {
		return isPago;
	}
	public void setIsPago(Boolean isPago) {
		this.isPago = isPago;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Boleto converter() {
		return new Boleto(dtPagamento, isPago, usuario);
	}
	
	public Boleto atualizar(Long id, BoletoRepository boletoRepository) {
		Boleto boleto = boletoRepository.getOne(id);
		boleto.setDtPagamento(this.dtPagamento);
		boleto.setIsPago(this.isPago);
		boleto.setUsuario(this.usuario);
		return boleto;
	}
}
