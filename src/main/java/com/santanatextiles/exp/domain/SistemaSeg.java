package com.santanatextiles.exp.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="SISTEMA",schema="SEG")
public class SistemaSeg implements Serializable {	

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SISTEMA")
    @SequenceGenerator(name = "SQ_SISTEMA", sequenceName = "SEG.SQ_SISTEMA", allocationSize = 1)	 
	@Column(name="ID")	 
	private Long id;
	
	@Column(name="SIGLA")	 
	private String sigla;
	
	@Column(name="DESCRICAO")	 
	private String nome;
	
	@Column(name="TIPO_LOGIN")	 
	private String tipoLogin;		
	
	@Column(name="SENHA_CODIFICACAO")	 
	private String tipoCodificacaoSenha;

	public SistemaSeg() {
		 
	}

	public SistemaSeg(Long id, String sigla, String nome, String tipoLogin, String tipoCodificacaoSenha) {
		super();
		this.id = id;
		this.sigla = sigla;
		this.nome = nome;
		this.tipoLogin = tipoLogin;
		this.tipoCodificacaoSenha = tipoCodificacaoSenha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoLogin() {
		return tipoLogin;
	}

	public void setTipoLogin(String tipoLogin) {
		this.tipoLogin = tipoLogin;
	}

	public String getTipoCodificacaoSenha() {
		return tipoCodificacaoSenha;
	}

	public void setTipoCodificacaoSenha(String tipoCodificacaoSenha) {
		this.tipoCodificacaoSenha = tipoCodificacaoSenha;
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
		SistemaSeg other = (SistemaSeg) obj;
		return Objects.equals(id, other.id);
	}
	 
	
	
	
}
