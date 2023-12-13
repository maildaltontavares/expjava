package com.santanatextiles.exp.domain.DTO; 
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import com.santanatextiles.exp.resource.utils.URL;


 
public class CredenciaisDTO  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id; 
	private String login;
	private String senha;
	private Long idSistema;
	private String idfil;
	
	public CredenciaisDTO() {
		
	}

	public Long getId() { 
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}
/*
	public void setSenha(String senha) {
		this.senha = senha;
	}
*/

	public void setSenha(String senha) {
		try {
			this.senha = URL.criptografaMD5(senha);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Long getIdSistema() {
		return idSistema;
	}

	public void setIdSistema(Long idSistema) {
		this.idSistema = idSistema;
	}

	public String getIdfil() {
		return idfil;
	}

	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}
 
 
	

}
