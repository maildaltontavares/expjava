package com.santanatextiles.exp.domain.DTO;

import jakarta.persistence.Column;

public class UsuarioSegDTO {

	
    private Long idUsuario; 
	private String idfil; 
	private String nome; 
	private String email;
	
	public UsuarioSegDTO() {
	 
	}

	public UsuarioSegDTO(Long idUsuario, String idfil, String nome, String email) {
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
	
	
	
	
	
	
	
	
}
