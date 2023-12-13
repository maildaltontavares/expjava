package com.santanatextiles.exp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.exp.domain.ItemTrackOS;
import com.santanatextiles.exp.domain.DTO.ItemTrackOsDTO;
import com.santanatextiles.exp.repositories.ItemTrackOSRepository; 
 
@Service
public class ItemTrackOSService {
	
    @Autowired
    private ItemTrackOSRepository repo;
	
    public ItemTrackOS buscaByIdSGS(Double idsgs) {   
	 	return repo.findByIdSGS(idsgs);
     }		
    
    
	@Transactional
	public ItemTrackOS insert(ItemTrackOS i) {	  
		ItemTrackOS it = repo.save(i); 
		return it;
	}     
    
	@Transactional
	public ItemTrackOS update(ItemTrackOsDTO i) {	
		
		ItemTrackOS it;
		ItemTrackOS itTmp = buscaByIdSGS(i.getIdSGS());	
	
		if(itTmp==null) {   // item novo
			
			itTmp.setIdSGS(i.getIdSGS()); 
			itTmp.setIdTrackOS(i.getIdTrackOS()); 
			itTmp.setAtivo("S"); 
			itTmp.setIdfil(i.getIdfil()); 
			
			 it = this.insert(itTmp);
			
		}else {  
			
			if(itTmp.getIdTrackOS()==null) {			
			   itTmp.setIdTrackOS(i.getIdTrackOS());
			}  
			
			it = repo.save(itTmp);
		} 
		
		return it;
	}    
    
   

}
