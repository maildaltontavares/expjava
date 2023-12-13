package com.santanatextiles.exp.domain.DTO; 
import java.io.Serializable;

public class UsuarioLoginDTO  implements Serializable {

	private static final long serialVersionUID = 1L; 
	
    private Long id; 
	private Long idUsuario; 
	private Long idSistema; 
	private String login; 
	private String senha;
	private int perfil;
	private String nomeUsuario;
	private String senhaAnterior;
	private String idfil;
	


	public UsuarioLoginDTO() {
		 
	}
	
	

	public UsuarioLoginDTO(Long id, Long idUsuario, Long idSistema, String login, String senha, int perfil,String idfil) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.idSistema = idSistema;
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;
		this.idfil = idfil;
	}



	public UsuarioLoginDTO(Long id, Long idUsuario, Long idSistema, String login, String senha) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.idSistema = idSistema;
		this.login = login;
		this.senha = senha;
	}  
	
	public UsuarioLoginDTO(Long idSistema, String login, String nomeUsuario) {
		super();
		this.idSistema = idSistema;
		this.login = login;
		this.nomeUsuario = nomeUsuario;
	}  

	public UsuarioLoginDTO(Long id, Long idUsuario, Long idSistema, String login, String senha, String senhaAnterior) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.idSistema = idSistema;
		this.login = login;
		this.senha = senha;
		this.senhaAnterior = senhaAnterior;
	}

	public String getSenhaAnterior() {
		return senhaAnterior;
	}

	public void setSenhaAnterior(String senhaAnterior) {
		this.senhaAnterior = senhaAnterior;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdSistema() {
		return idSistema;
	}

	public void setIdSistema(Long idSistema) {
		this.idSistema = idSistema;
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

	public void setSenha(String senha) {
		this.senha = senha;
	}



	public int getPerfil() {
		return perfil;
	}



	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}



	public String getIdfil() {
		return idfil;
	}



	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}
	
	
	
	
	
	
 
	
	

}

