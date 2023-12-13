package com.santanatextiles.exp.resources;

import java.sql.SQLException;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.exp.domain.UsuarioSeg;
import com.santanatextiles.exp.services.UsuarioSegService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/usuarioseg")
public class UsuarioSegResource {
	
	
	@Autowired
	private UsuarioSegService service; 
	
	@CrossOrigin
	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<?> FindAll(){  
		try {
		    List<UsuarioSeg> usuarioSeg = service.findAll(); 
		    return ResponseEntity.status(HttpStatus.OK).body(usuarioSeg);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 	 
	} 
	
	@CrossOrigin
	@RequestMapping(value="/usuario/{idUsuario}", method=RequestMethod.GET)
	public ResponseEntity<?> FindById(@PathVariable Long idUsuario){  
		try {
			UsuarioSeg usuarioSeg = service.findById(idUsuario); 
			return ResponseEntity.status(HttpStatus.OK).body(usuarioSeg);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 	 
	}	
	
	@CrossOrigin
	@RequestMapping(value="/nome/{nomeUsuario}", method=RequestMethod.GET)
	public ResponseEntity<?> FindByNome(@PathVariable String nomeUsuario){  
		try {
		    List<UsuarioSeg> usuarioSeg = service.buscaUsuarioPorNome(nomeUsuario); 
		    return ResponseEntity.status(HttpStatus.OK).body(usuarioSeg);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 	 
	}	
	
	@CrossOrigin
	@RequestMapping(value="/nome_usu", method=RequestMethod.POST)
	public ResponseEntity<?> buscaUsuarioPorNome(@Valid @RequestBody UsuarioSeg objDTO ){  
		try {
		    List<UsuarioSeg> usuarioSeg = service.buscaUsuarioPorNome(objDTO.getNome()); 
		    return ResponseEntity.status(HttpStatus.OK).body(usuarioSeg);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 	 
	}		
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<?> update (@Valid @RequestBody UsuarioSeg objDTO ) {  
		try {
		     UsuarioSeg obj = service.update(objDTO);
		     return ResponseEntity.status(HttpStatus.OK).body(obj.getIdUsuario());
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 	 		
	} 
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> insert (@Valid @RequestBody UsuarioSeg objDTO ) {  
		try {
		    UsuarioSeg obj = service.insert(objDTO);
		    return ResponseEntity.status(HttpStatus.OK).body(obj.getIdUsuario());
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 			    
	}	 
	
	@CrossOrigin
	@RequestMapping(value="/usuario/{idUsuario}",method=RequestMethod.DELETE)
	public ResponseEntity<?> deletaUsuario(@PathVariable  Long idUsuario ){  
		try {
			service.deleteById(idUsuario);
			return ResponseEntity.status(HttpStatus.OK).body(  idUsuario.toString()  );
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 	 
	} 
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/permissao/{sistema}/{usuario}",method=RequestMethod.GET)
     public ResponseEntity<?> usuarioPermissao( @PathVariable String sistema, @PathVariable String usuario) throws SQLException {
          try {
                JSONArray lista = service.usuarioPermissao(  sistema, usuario);
                return ResponseEntity.ok().body(lista.toString());
          } catch(Exception e) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
          } 
     } 

}
