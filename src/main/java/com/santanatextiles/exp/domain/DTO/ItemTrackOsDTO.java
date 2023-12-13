package com.santanatextiles.exp.domain.DTO;

import java.io.Serializable;

public class ItemTrackOsDTO implements Serializable {

	private static final long serialVersionUID = 1L; 
	 
	private Double idSGS;	 
	private String idTrackOS; 
	private String idfil;	 
	private String ativo;	 
	private String tag;		 
	private String obs;
 
	
	public ItemTrackOsDTO() {
		
	}
	
	public ItemTrackOsDTO(Double idSGS, String idTrackOS, String idfil, String ativo, String tag, String obs) {
		super();
		this.idSGS = idSGS;
		this.idTrackOS = idTrackOS;
		this.idfil = idfil;
		this.ativo = ativo;
		this.tag = tag;
		this.obs = obs;
	} 
	

	public ItemTrackOsDTO(Double idSGS, String idTrackOS, String idfil) {
		super();
		this.idSGS = idSGS;
		this.idTrackOS = idTrackOS;
		this.idfil = idfil;
	}

	public Double getIdSGS() {
		return idSGS;
	}

	public void setIdSGS(Double idSGS) {
		this.idSGS = idSGS;
	}

	public String getIdTrackOS() {
		return idTrackOS;
	}

	public void setIdTrackOS(String idTrackOS) {
		this.idTrackOS = idTrackOS;
	}

	public String getIdfil() {
		return idfil;
	}

	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
	
	
	
	
	
	
	

}


