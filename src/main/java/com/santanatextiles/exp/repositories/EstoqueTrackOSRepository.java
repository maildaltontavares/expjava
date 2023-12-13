package com.santanatextiles.exp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.santanatextiles.exp.domain.EstoqueSGS;
import com.santanatextiles.exp.projections.EstoqueTrackOSProjection;
  

@Repository
public interface EstoqueTrackOSRepository extends JpaRepository<EstoqueSGS , Double> {
	
	
    @Query(value =  
    	    "Select " +
    	    " filial,   " +
    		" nome,   " +
    		" descricao, " +
    		" codigo,  " +
    		" qtde_disponivel,  " +
    		" qtde_min,  " +  
    		" qtde_max,   " +
    		" custo_unitario,  " +
    		" UM,  " +
    		" tempo_espera,  " +
    		" ncm,  " +
    		" codigo_qr,  " +
    		" ativos_relacionados,  " +
    		" local,  " +
    		" responsaveis,  " +
    		" imagens,  " +
    		" anexos,   " + 
    		" idt.idtrack  idtrackOS,  " +
    		" v.dt_ult_alteracao dtUltAlteracao" +
    	    " from stl.v_stl_item_trackOs v " +    		
			" inner join MAN.ITTRAKOS_DBF idt on idt.idfil = v.filial and v.codigo = idt.idsgs " + 
			" and idt.idtrack is not null and idt.ativo = 'S' " +     	
			" where v.filial =  ?1 " + 
			" order by nome" 
    	     ,nativeQuery = true)
    	    List<EstoqueTrackOSProjection> buscaItensTrackOS(Integer filial) ;
    
    
    @Query(value =  
    	    "Select " +
    	    " filial,   " +
    		" nome,   " +
    		" descricao, " +
    		" codigo,  " +
    		" qtde_disponivel,  " +
    		" qtde_min,  " +  
    		" qtde_max,   " +
    		" custo_unitario,  " +
    		" UM,  " +
    		" tempo_espera,  " +
    		" ncm,  " +
    		" codigo_qr,  " +
    		" ativos_relacionados,  " +
    		" local,  " +
    		" responsaveis,  " +
    		" imagens,  " +
    		" anexos,   " + 
    		" idt.idtrack  idtrackOS,  " +
    		" v.dt_ult_alteracao dtUltAlteracao" +
    	    " from stl.v_stl_item_trackOs v " +    		
			" inner join MAN.ITTRAKOS_DBF idt on idt.idfil = v.filial and v.codigo = idt.idsgs " + 
			" and idt.idtrack is not null and idt.ativo = 'S' " +     	
    	     "where v.filial =  ?1 " +
			" and v.dt_ult_alteracao >= sysdate - 3" +
			" order by nome"    
    	     ,nativeQuery = true)
    	    List<EstoqueTrackOSProjection> buscaItensTrackOSPorData(Integer filial) ;    

}



