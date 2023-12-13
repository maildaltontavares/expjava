package com.santanatextiles.exp.resources;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.exp.domain.ItemTrackOS;
import com.santanatextiles.exp.domain.DTO.ItemTrackOsDTO;
import com.santanatextiles.exp.services.ItemTrackOSService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/item")

public class ItemTrackOSResource {
	
	@Autowired
	private ItemTrackOSService service; 
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<?> update (@Valid @RequestBody ItemTrackOsDTO objDTO ) throws UnsupportedEncodingException{ 
		try {
			/*
			ItemTrackOS ItemTrackOSTmp = new ItemTrackOS();
			
			ItemTrackOSTmp.setIdfil(objDTO.getIdfil());
			ItemTrackOSTmp.setIdTrackOS(objDTO.getIdTrackOS());
			ItemTrackOSTmp.setIdSGS(objDTO.getIdSGS());
			*/
			ItemTrackOS obj = service.update(objDTO);
			
		return ResponseEntity.status(HttpStatus.OK).body(obj.getIdSGS());
		}   catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 			
	}	
	
	
	@CrossOrigin
	@RequestMapping(value="/itemSGS/{idItemSGS}", method=RequestMethod.GET)
	public ResponseEntity<?> findByIdSGS(@PathVariable Double idItemSGS){  	
		try	{
			ItemTrackOS  itemTrackOS = service.buscaByIdSGS(idItemSGS);  
		    return ResponseEntity.status(HttpStatus.OK).body(itemTrackOS);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 
	} 	
	
	
	
	
	

}
