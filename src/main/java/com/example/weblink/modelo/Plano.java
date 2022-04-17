package com.example.weblink.modelo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Plano {
	
	@Id
	private Long id;
	private String nomePlano;
	private float valor;
	private String qtdMega;
	
	@Override
	public int hashCode() {
		return Objects.hash(id, nomePlano, qtdMega, valor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plano other = (Plano) obj;
		return  Objects.equals(id, other.id)
				&& Objects.equals(nomePlano, other.nomePlano) && Objects.equals(qtdMega, other.qtdMega)
				&& Float.floatToIntBits(valor) == Float.floatToIntBits(other.valor);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomePlano() {
		return nomePlano;
	}
	public void setNomePlano(String nomePlano) {
		this.nomePlano = nomePlano;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getQtdMega() {
		return qtdMega;
	}
	public void setQtdMega(String qtdMega) {
		this.qtdMega = qtdMega;
	}
	
}
