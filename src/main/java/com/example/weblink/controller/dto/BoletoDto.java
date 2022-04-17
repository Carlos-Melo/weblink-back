package com.example.weblink.controller.dto;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.example.weblink.modelo.Boleto;
import com.example.weblink.modelo.Usuario;

public class BoletoDto {
	
	private Long id;
	private Date dtPagamento;
	private Boolean isPago;
	private Usuario usuario;
	
	public BoletoDto(Boleto boleto) {
		this.id = boleto.getId();
		this.dtPagamento = boleto.getDtPagamento();
		this.isPago = boleto.getIsPago();
		this.usuario = boleto.getUsuario();
	}

	public Long getId() {
		return id;
	}

	public Date getDtPagamento() {
		return dtPagamento;
	}

	public Boolean getIsPago() {
		return isPago;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public static List<BoletoDto> converter(List<Boleto> boletos) {
		return boletos.stream().map(BoletoDto::new).collect(Collectors.toList());
	}
	
}
