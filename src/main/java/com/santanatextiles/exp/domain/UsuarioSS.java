package com.santanatextiles.exp.domain;
 

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.santanatextiles.exp.domain.enums.PerfilUsuario;



public class UsuarioSS implements UserDetails,Serializable {

	private static final long serialVersionUID = 1L;

	private String idfil;
	
	private String codigo;

	private String login;

	private String nome;

	private String senha;
	
	private int perfil;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	long sistema;
	
	Long idUsuario;
	
	public UsuarioSS() {
		
	}
	
	
	
	

	
	public UsuarioSS(String idfil, String codigo , String login, String nome, String senha,  int perfil,
			Set<PerfilUsuario> perfis , long sistema, Long idUsuario)  {
		super();
		this.idfil = idfil;
		this.codigo = codigo;
		this.login = login;
		this.nome = nome;
		this.senha = senha;
		this.perfil = perfil;
		this.authorities = perfis.stream().map( x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
		this.sistema = sistema;
		this.idUsuario = idUsuario;
		
	}  

	public String getIdfil() {
		return idfil;
	}

	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public PerfilUsuario getPerfil() {
		return PerfilUsuario.toEnum(perfil);
	}

	public void setPerfil(PerfilUsuario perfil) {
		this.perfil = perfil.getCodigo();
	} 

	public long getSistema() {
		return sistema;
	}


	public void setSistema(long sistema) {
		this.sistema = sistema;
	}

	
	
	

	public Long getIdUsuario() {
		return idUsuario;
	}






	public void setId(Long idUsuario) {
		this.idUsuario = idUsuario;
	}







	@Override
	public int hashCode() {
		return Objects.hash(login, sistema);
	}






	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioSS other = (UsuarioSS) obj;
		return Objects.equals(login, other.login) && sistema == other.sistema;
	}






	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return codigo;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	

}
