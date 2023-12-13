package com.santanatextiles.exp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.exp.domain.SistemaSeg;
import com.santanatextiles.exp.services.SistemaSegService;

@RestController
@RequestMapping(value="/sistema")
public class SistemaSegResource {
	
	@Autowired
	private SistemaSegService service;
	
	
	@CrossOrigin
	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<?> buscaSistema(){  
		try {
			List<SistemaSeg> sistemaSeg = service.buscaSistema(); 
			return ResponseEntity.status(HttpStatus.OK).body(sistemaSeg);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		 
	} 
	
	@CrossOrigin
	@RequestMapping(value="/{idSistema}", method=RequestMethod.GET)
	public ResponseEntity<?> FindById(@PathVariable Long idSistema){  
		try {
			SistemaSeg sistemaSeg = service.findById(idSistema); 
			return ResponseEntity.status(HttpStatus.OK).body(sistemaSeg);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		 
	}	
	
	

}
