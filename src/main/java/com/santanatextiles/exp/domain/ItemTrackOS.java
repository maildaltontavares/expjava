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
@Table(name="ITTRAKOS_DBF",schema="MAN")
public class ItemTrackOS implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IDSGS")
	private Double idSGS;
	
	@Column(name="IDTRACK")
	private String idTrackOS;	
 
	@Column(name="IDFIL")
	private String idfil;		
	
	@Column(name="ATIVO")
	private String ativo;		
	
	@Column(name="TAG")
	private String tag;		
	
	@Column(name="OBS")
	private String obs;
	
	public ItemTrackOS() {
		
	}

	 

	public ItemTrackOS(Double idSGS, String idTrackOS, String idfil, String ativo, String tag, String obs) {
		super();
		this.idSGS = idSGS;
		this.idTrackOS = idTrackOS;
		this.idfil = idfil;
		this.ativo = ativo;
		this.tag = tag;
		this.obs = obs;
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

	public String getIdfil() {
		return idfil;
	}



	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}



	@Override
	public int hashCode() {
		return Objects.hash(idSGS);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemTrackOS other = (ItemTrackOS) obj;
		return Objects.equals(idSGS, other.idSGS);
	}	
	
	
	
	
	
	
	
	
	
	
	
}