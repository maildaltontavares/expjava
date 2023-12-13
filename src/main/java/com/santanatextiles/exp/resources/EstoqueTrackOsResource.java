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

import com.santanatextiles.exp.dto.ItensTrackOSDTO;
import com.santanatextiles.exp.services.AtualizaEstoqueTrackOsService;
import com.santanatextiles.exp.services.EstoqueTrackOSService;

@RestController
@RequestMapping(value="/estoque")
public class EstoqueTrackOsResource { 
	
	@Autowired
	private EstoqueTrackOSService service;  
 
	
	@Autowired
	private AtualizaEstoqueTrackOsService serviceApi;
	
	@CrossOrigin
	@RequestMapping(value="/filial/{filial}", method=RequestMethod.GET)
	public ResponseEntity<List<ItensTrackOSDTO>> buscaEstoque(@PathVariable String filial){ 
		Integer idfil =   Integer.parseInt(filial);  		
		List<ItensTrackOSDTO> listaItensTrackOS = service.buscaItensTrackOS(idfil);  
		return ResponseEntity.status(HttpStatus.OK).body(listaItensTrackOS);  
	}	
	
	
	@CrossOrigin
	@RequestMapping(value="data/filial/{filial}", method=RequestMethod.GET)
	public ResponseEntity<List<ItensTrackOSDTO>> buscaEstoquePorData(@PathVariable String filial){ 
		Integer idfil =   Integer.parseInt(filial);  		
		List<ItensTrackOSDTO> listaItensTrackOS = service.buscaItensTrackOSPorData(idfil);  
		return ResponseEntity.status(HttpStatus.OK).body(listaItensTrackOS);
 
	}		
	
	
	@CrossOrigin
	@RequestMapping(value="cargaauto/filial/{filial}", method=RequestMethod.GET)
	public ResponseEntity<List<ItensTrackOSDTO>> jobAtualizaEstoqueTrackOs(@PathVariable String filial){ 
		Integer idfil =   Integer.parseInt(filial);  		
		List<ItensTrackOSDTO> listaItensTrackOS = serviceApi.atualizaEstoqueTrackOS(idfil);  
		return ResponseEntity.status(HttpStatus.OK).body(listaItensTrackOS);
 
	}		
		
	
	
	
}
