package com.santanatextiles.exp.domain.enums;

public enum PerfilUsuario {
	
	ADMIN(1, "ROLE_ADMIN"),
	USER(2, "ROLE_USER");
	
	private int codigo;
	private String descricao;
	
	private PerfilUsuario(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static PerfilUsuario toEnum(Integer codigo) {
		if(codigo == null) {
			return null;
		}
		
		for (PerfilUsuario x : PerfilUsuario.values()) {
			if( codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido" + codigo);
	}
	
}

