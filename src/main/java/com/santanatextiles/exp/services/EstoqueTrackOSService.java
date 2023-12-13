package com.santanatextiles.exp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.exp.dto.ItensTrackOSDTO;
import com.santanatextiles.exp.projections.EstoqueTrackOSProjection;
import com.santanatextiles.exp.repositories.EstoqueTrackOSRepository; 

@Service
public class EstoqueTrackOSService {
	
		@Autowired
		private EstoqueTrackOSRepository repo; 
		
		public List<ItensTrackOSDTO> buscaItensTrackOS(Integer idfil){
			
			List<EstoqueTrackOSProjection> itensTrackOs = repo.buscaItensTrackOS(idfil); 
			return itensTrackOs.stream().map(x-> new ItensTrackOSDTO(x)).toList(); 
			
		}
		
		public List<ItensTrackOSDTO> buscaItensTrackOSPorData(Integer idfil){
			
			List<EstoqueTrackOSProjection> itensTrackOs = repo.buscaItensTrackOSPorData(idfil); 
			return itensTrackOs.stream().map(x-> new ItensTrackOSDTO(x)).toList(); 
			
		}		
		
		
		

}
