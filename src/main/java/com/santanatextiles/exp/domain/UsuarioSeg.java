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
@Table(name="USUARIO",schema="SEG")
public class UsuarioSeg implements Serializable {	

	private static final long serialVersionUID = 1L;
	 
	@Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USUARIO")
    @SequenceGenerator(name = "SQ_USUARIO", sequenceName = "SEG.SQ_USUARIO", allocationSize = 1)	  
	@Column(name="ID")	
	private Long idUsuario;
	
	@Column(name="IDFIL")	
	private String idfil;
	
	@Column(name="NOME")	
	private String nome;
	
	@Column(name="EMAIL")	
	private String email;

	public UsuarioSeg() {
	 
	}

	public UsuarioSeg(Long idUsuario, String idfil, String nome, String email) {
		super();
		this.idUsuario = idUsuario;
		this.idfil = idfil;
		this.nome = nome;
		this.email = email;
	}

  

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getIdfil() {
		return idfil;
	}

	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioSeg other = (UsuarioSeg) obj;
		return Objects.equals(idUsuario, other.idUsuario);
	}
	
	
	 
	
	
	
	
	
	
	

}
