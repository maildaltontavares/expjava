package com.santanatextiles.exp.resources;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.exp.domain.UsuarioLogin;
import com.santanatextiles.exp.domain.DTO.UsuarioLoginDTO;
import com.santanatextiles.exp.services.UsuarioLoginService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/usuariologin")
public class UsuarioLoginResource {

	@Autowired
	private UsuarioLoginService service;
	
	@CrossOrigin
	@RequestMapping(value="/{idUsuarioLogin}", method=RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long idUsuarioLogin){  		
		try	{
		    UsuarioLogin  usuarioLogin = service.findById(idUsuarioLogin);  
		    return ResponseEntity.status(HttpStatus.OK).body(usuarioLogin);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 
	} 
	
	@CrossOrigin
	@RequestMapping(value="/usuario/{idUsuario}/sistema/{idSistema}", method=RequestMethod.GET)
	public ResponseEntity<?> findByIdUsuarioAndIdSistema(@PathVariable Long idUsuario,@PathVariable Long idSistema){  
		try	{		 
			UsuarioLogin  usuarioLogin = service.findByIdUsuarioAndIdSistema(idUsuario,idSistema);  
			return ResponseEntity.status(HttpStatus.OK).body(usuarioLogin);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  
	}
	
 	@CrossOrigin
 	@RequestMapping(value="/buscasistemausuario", method=RequestMethod.POST)
	public  ResponseEntity<?>buscaSistemaUsuario(@Valid @RequestBody UsuarioLoginDTO  objDTO ){ 
		try	{		 		
 		   //System.out.println("pesquisaProducaoFiacaoByParam   " + objDTO.getCodigoMaquina());
 		    List<Map<String, Object>> listaSistemaUsuario = service.buscaSistemaUsuario(objDTO.getIdSistema(), objDTO.getNomeUsuario(),objDTO.getLogin());
 		    return ResponseEntity.status(HttpStatus.OK).body(listaSistemaUsuario);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
	}	 

	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> insert (@Valid @RequestBody UsuarioLoginDTO objDTO ){  
		try	{	
			objDTO.setLogin(objDTO.getLogin().toLowerCase());
			UsuarioLogin obj = service.insert(objDTO);
			return ResponseEntity.status(HttpStatus.OK).body(obj.getId());
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		 
	}	
	
	@CrossOrigin
	@RequestMapping(value="/trocarsenha",method=RequestMethod.POST)
	public ResponseEntity<?> trocaSenha (@Valid @RequestBody UsuarioLoginDTO objDTO ) throws Exception, UnsupportedEncodingException{	 	
		try {
			UsuarioLogin obj = service.trocaSenha(objDTO); 
			return ResponseEntity.status(HttpStatus.OK).body(obj.getId().toString());
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}		 
	}	 
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<?> update (@Valid @RequestBody UsuarioLoginDTO objDTO ) throws UnsupportedEncodingException{ 
		try {
		    objDTO.setLogin(objDTO.getLogin().toLowerCase());
		    UsuarioLogin obj = service.update(objDTO);
		return ResponseEntity.status(HttpStatus.OK).body(obj.getId());
		}   catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 			
	}
		
	
	@CrossOrigin
	@RequestMapping(value="/usuario/{idUsuario}/sistema/{idSistema}",method=RequestMethod.DELETE)
	public ResponseEntity<?> deletaUsuario(@PathVariable  Long idUsuario, @PathVariable Long idSistema){  
		try {
		    service.deletaUsuario(idUsuario,idSistema);
		    return ResponseEntity.status(HttpStatus.OK).body(  idUsuario.toString() );
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 	
	}	
	
	
	 
 	@CrossOrigin
 	@RequestMapping(value="/login", method=RequestMethod.POST)
	public  ResponseEntity<UsuarioLogin>findByLoginAndIdSistema(@Valid @RequestBody UsuarioLoginDTO  objDTO ){ 
 		
 		//System.out.println("pesquisaProducaoFiacaoByParam   " + objDTO.getCodigoMaquina());
 		UsuarioLogin usuarioLogin = service.findByLoginAndIdSistema(objDTO);
 		return ResponseEntity.status(HttpStatus.OK).body(usuarioLogin);
	}	 	
 	 
	
	
}
