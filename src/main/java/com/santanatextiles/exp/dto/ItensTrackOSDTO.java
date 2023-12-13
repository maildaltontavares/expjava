package com.santanatextiles.exp.dto;

import java.util.Date;

import com.santanatextiles.exp.projections.EstoqueTrackOSProjection;

public class ItensTrackOSDTO {	
	
	private Integer filial;
	private String nome;
	private String descricao;
	private Long codigo; 
	private Double qtde_disponivel;
	private Double qtde_min;
	private Double qtde_max;
	private Double custo_unitario;
	private String UM;
	private Double tempo_espera;
	private String ncm;
	private Long codigo_qr;
	private String ativos_relacionados;
	private String local;
	private String responsaveis;
	private String imagens;
	private String anexos;
	private String idTrackOS;
	private Date dtUltAlteracao;
	
	 


	public ItensTrackOSDTO() {
		
	}
	
	public ItensTrackOSDTO(EstoqueTrackOSProjection projection ) {
	
		this.filial = projection.getFilial();
		this.nome = projection.getNome();
		this.descricao = projection.getDescricao();
		this.codigo   = projection.getCodigo(); 
		this.qtde_disponivel = projection.getQtde_disponivel();
		this.qtde_min = projection.getQtde_min();
		this.qtde_max = projection.getQtde_max();
		this.custo_unitario = projection.getCusto_unitario();
		this.UM = projection.getUM();
		this.tempo_espera = projection.getTempo_espera();
		this.ncm = projection.getNcm();
		this.codigo_qr   = projection.getCodigo_qr();
		this.ativos_relacionados = projection.getAtivos_relacionados();
		this.local = ""; // projection.getLocal();
		this.responsaveis = projection.getResponsaveis();
		this.imagens = projection.getImagens();
		this.anexos = projection.getAnexos(); 
		this.idTrackOS = projection.getIdTrackOS();
		this.dtUltAlteracao = projection.getDtUltAlteracao();
		 
 
	}
	

	

 


 
	public ItensTrackOSDTO(Integer filial, String nome, String descricao, Long codigo, Double qtde_disponivel,
			Double qtde_min, Double qtde_max, Double custo_unitario, String uM, Double tempo_espera, String ncm,
			Long codigo_qr, String ativos_relacionados, String local, String responsaveis, String imagens,
			String anexos, String idTrackOS, Date dtUltAlteracao) {
		super();
		this.filial = filial;
		this.nome = nome;
		this.descricao = descricao;
		this.codigo = codigo;
		this.qtde_disponivel = qtde_disponivel;
		this.qtde_min = qtde_min;
		this.qtde_max = qtde_max;
		this.custo_unitario = custo_unitario;
		UM = uM;
		this.tempo_espera = tempo_espera;
		this.ncm = ncm;
		this.codigo_qr = codigo_qr;
		this.ativos_relacionados = ativos_relacionados;
		this.local = local;
		this.responsaveis = responsaveis;
		this.imagens = imagens;
		this.anexos = anexos;
		this.idTrackOS = idTrackOS;
		this.dtUltAlteracao = dtUltAlteracao;
	}

	public Integer getFilial() {
		return filial;
	} 

	public void setFilial(Integer filial) {
		this.filial = filial;
	}
 

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public Double getQtde_disponivel() {
		return qtde_disponivel;
	}


	public void setQtde_disponivel(Double qtde_disponivel) {
		this.qtde_disponivel = qtde_disponivel;
	}


	public Double getQtde_min() {
		return qtde_min;
	}


	public void setQtde_min(Double qtde_min) {
		this.qtde_min = qtde_min;
	}


	public Double getQtde_max() {
		return qtde_max;
	}


	public void setQtde_max(Double qtde_max) {
		this.qtde_max = qtde_max;
	}


	public Double getCusto_unitario() {
		return custo_unitario;
	}


	public void setCusto_unitario(Double custo_unitario) {
		this.custo_unitario = custo_unitario;
	}


	public String getUM() {
		return UM;
	}


	public void setUM(String uM) {
		UM = uM;
	}


	public Double getTempo_espera() {
		return tempo_espera;
	}


	public void setTempo_espera(Double tempo_espera) {
		this.tempo_espera = tempo_espera;
	}


	public String getNcm() {
		return ncm;
	}


	public void setNcm(String ncm) {
		this.ncm = ncm;
	}


	public Long getCodigo_qr() {
		return codigo_qr;
	}


	public void setCodigo_qr(Long codigo_qr) {
		this.codigo_qr = codigo_qr;
	}


	public String getAtivos_relacionados() {
		return ativos_relacionados;
	}


	public void setAtivos_relacionados(String ativos_relacionados) {
		this.ativos_relacionados = ativos_relacionados;
	}


	public String getLocal() {
		return local;
	}


	public void setLocal(String local) {
		this.local = local;
	}


	public String getResponsaveis() {
		return responsaveis;
	}


	public void setResponsaveis(String responsaveis) {
		this.responsaveis = responsaveis;
	}


	public String getImagens() {
		return imagens;
	}


	public void setImagens(String imagens) {
		this.imagens = imagens;
	}


	public String getAnexos() {
		return anexos;
	}


	public void setAnexos(String anexos) {
		this.anexos = anexos;
	}

	public String getIdTrackOS() {
		return idTrackOS;
	}

	public void setIdTrackOS(String idTrackOS) {
		this.idTrackOS = idTrackOS;
	}
	 
	
	
	public Date getDtUltAlteracao() {
		return dtUltAlteracao;
	}

	public void setDtUltAlteracao(Date dtUltAlteracao) {
		this.dtUltAlteracao = dtUltAlteracao;
	}	
	
	
	
	
	
	

}
