package com.santanatextiles.exp.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="E1426_SGS_SALDO_ITEM_PERIODO",schema="SGS")

public class EstoqueSGS implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="D1426_ID_SALDO_ITEM_PERIODO")
	private Double id;
	
	@Column(name="D1426_PERIODO_MOVIMENTO")	 
	private String periodo; 
	
	@Column(name="D0422_ID_ITEM")	  
	private Double item;	
	
	@Column(name="D1426_QUANT_ESTOQUE")	  
	private Double qtde_estoque;	
	 
	@Column(name="D1426_VLR_ESTOQUE")	
	private Double valor_estoque;	
	
	@Column(name="D0002_ID_FIL")	
	public Integer idfil;
	
	
	public EstoqueSGS() {
		
		
	}

	public EstoqueSGS(Double id, String periodo, Double item, Double qtde_estoque, Double valor_estoque,
			Integer idfil) {
		super();
		this.id = id;
		this.periodo = periodo;
		this.item = item;
		this.qtde_estoque = qtde_estoque;
		this.valor_estoque = valor_estoque;
		this.idfil = idfil;
	}

	public Double getId() {
		return id;
	}

	public void setId(Double id) {
		this.id = id;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Double getItem() {
		return item;
	}

	public void setItem(Double item) {
		this.item = item;
	}

	public Double getQtde_estoque() {
		return qtde_estoque;
	}

	public void setQtde_estoque(Double qtde_estoque) {
		this.qtde_estoque = qtde_estoque;
	}

	public Double getValor_estoque() {
		return valor_estoque;
	}

	public void setValor_estoque(Double valor_estoque) {
		this.valor_estoque = valor_estoque;
	}

	public Integer getIdfil() {
		return idfil;
	}

	public void setIdfil(Integer idfil) {
		this.idfil = idfil;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstoqueSGS other = (EstoqueSGS) obj;
		return Objects.equals(id, other.id);
	}
 
	
	

}
