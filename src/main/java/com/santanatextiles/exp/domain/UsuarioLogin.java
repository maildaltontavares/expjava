package com.santanatextiles.exp.domain;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.santanatextiles.exp.domain.enums.PerfilUsuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="USUARIO_LOGIN",schema="SEG", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"USUARIO_ID", "SISTEMA_ID"}),
		@UniqueConstraint(columnNames = {"LOGIN", "SISTEMA_ID"}),
		})
public class UsuarioLogin implements Serializable {	

	private static final long serialVersionUID = 1L;
	 
	@Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USUARIO_LOGIN")
    @SequenceGenerator(name = "SQ_USUARIO_LOGIN", sequenceName = "SEG.SQ_USUARIO_LOGIN", allocationSize = 1)	
 	@Column(name="ID", nullable = false)	 
	private Long id;
	
	@Column(name="USUARIO_ID")	 
	private Long idUsuario;
	
	@Column(name="SISTEMA_ID")	 
	private Long idSistema;  
	
	@Column(name="LOGIN")	 
	private String login;
	
	@Column(name="SENHA")	 
	private String senha;
	
	@Column(name="PERFIL_JWT")
	private int perfil;
	
	@ManyToOne
	@JoinColumns({ 
	    @JoinColumn(name="USUARIO_ID", referencedColumnName="ID", insertable = false, updatable = false)
	})
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private UsuarioSeg fkUsuario	;	
	
	@ManyToOne
	@JoinColumns({ 
	    @JoinColumn(name="SISTEMA_ID", referencedColumnName="ID", insertable = false, updatable = false)
	})
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private SistemaSeg fkSistema	;

	public UsuarioLogin() {
		 
	}

   
	
	public UsuarioLogin(Long id, Long idUsuario, Long idSistema, String login, String senha, int perfil,
			UsuarioSeg fkUsuario, SistemaSeg fkSistema) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.idSistema = idSistema;
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;
		this.fkUsuario = fkUsuario;
		this.fkSistema = fkSistema;
	}



	public UsuarioLogin(Long id, Long idUsuario, Long idSistema, String login, String senha) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.idSistema = idSistema;
		this.login = login;
		this.senha = senha;
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

	public UsuarioSeg getFkUsuario() {
		return fkUsuario;
	}

	public void setFkUsuario(UsuarioSeg fkUsuario) {
		this.fkUsuario = fkUsuario;
	}

	public SistemaSeg getFkSistema() {
		return fkSistema;
	}

	public void setFkSistema(SistemaSeg fkSistema) {
		this.fkSistema = fkSistema;
	}  
	 
	
	public PerfilUsuario getPerfil() {
		return PerfilUsuario.toEnum(perfil);
	}
/*
	public void setPerfil(PerfilUsuario perfil) {
		this.perfil = perfil.getCodigo();
	}
*/	
	public void setPerfil(int perfil) {
		this.perfil = perfil;
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
		UsuarioLogin other = (UsuarioLogin) obj;
		return Objects.equals(id, other.id);
	}
 
 
	
	
	
	
	
	
	
	
	
	

}

