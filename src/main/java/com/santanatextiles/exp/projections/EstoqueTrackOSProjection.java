package com.santanatextiles.exp.projections;

import java.util.Date;

public interface EstoqueTrackOSProjection { 
	
	Integer getFilial();
	String getNome();
	String getDescricao();
	Long   getCodigo(); 
	Double getQtde_disponivel();
	Double getQtde_min();
	Double getQtde_max();
	Double getCusto_unitario();
	String getUM();
	Double getTempo_espera();
	String getNcm();
	Long   getCodigo_qr();
	String getAtivos_relacionados();
	String getLocal();
	String getResponsaveis();
	String getImagens();
	String getAnexos();
	String getIdTrackOS(); 
	Date  getDtUltAlteracao();
	

}
