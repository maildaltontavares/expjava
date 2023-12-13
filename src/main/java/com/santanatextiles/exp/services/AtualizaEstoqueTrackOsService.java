package com.santanatextiles.exp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.exp.dto.ItensTrackOSDTO;
import com.santanatextiles.exp.projections.EstoqueTrackOSProjection;

@Service
public class AtualizaEstoqueTrackOsService {

	
	@Autowired
	private EstoqueTrackOSService service;   

	public List<ItensTrackOSDTO> atualizaEstoqueTrackOS(Integer idfil){
		
		List<ItensTrackOSDTO> listaItensTrackOS = service.buscaItensTrackOS(idfil);
		 
		
	    for (ItensTrackOSDTO item : listaItensTrackOS) {   	
	        
	    	System.out.println(item.getDescricao());
	    	System.out.println(item.getIdTrackOS());
	    	System.out.println(item.getQtde_disponivel());    	
	        
	        System.out.println(); // Adicione uma linha em branco para separar os itens
	    }	
	    
	    return listaItensTrackOS;
		
	}
	
	
	
	
	
   
	
}