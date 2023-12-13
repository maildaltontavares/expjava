package com.santanatextiles.exp.services;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.exp.domain.SistemaSeg;
import com.santanatextiles.exp.domain.UsuarioLogin;
import com.santanatextiles.exp.domain.DTO.UsuarioLoginDTO;
import com.santanatextiles.exp.repositories.UsuarioLoginRepository;
import com.santanatextiles.exp.resource.utils.URL;
import com.santanatextiles.exp.resources.exceptions.DataIntegrityException;



@Service
public class UsuarioLoginService {

	@Autowired
	private UsuarioLoginRepository repo;
	
	
	@Autowired 
	private SistemaSegService sistemaService;
	
	private ArrayList<String> msg = new ArrayList<>(); 	 
	
	public UsuarioLogin findById(Long id) {		
		Optional<UsuarioLogin> usuarioLogin = repo.findById(id);
		return usuarioLogin.orElse(null);
	}
	
	
	public UsuarioLogin findByIdUsuarioAndIdSistema(Long idUsuario,Long IdSistema) {		
		Optional<UsuarioLogin> usuarioLogin = repo.findByIdUsuarioAndIdSistema(idUsuario,IdSistema);
		return usuarioLogin.orElse(null);
	}	
	
	/// Novo metodo
	public 	UsuarioLogin buscaLoginSys (String login,long sistema) {
		
		UsuarioLogin usuLogin = repo.findByLoginAndIdSistema(login,sistema);

		if(usuLogin==null) {
			this.msg.add("Login inválido"); 
			throw new DataIntegrityException(String.join(",", this.msg)); 
			
		}
		
		return usuLogin;
	}
	
	public List<Map<String, Object>> buscaSistemaUsuario(long idSistema,String nomeUsuario,String login ){	 
		
		String sistemaSTR = Long.toString(idSistema);		
		List<Map<String, Object>> obj = repo.buscaSistemaUsuario(sistemaSTR , nomeUsuario.toUpperCase(), login.toUpperCase());
		
		
		return  obj;							 
	}  	
	
	public 	UsuarioLogin findByLoginAndIdSistema (UsuarioLoginDTO objDTO) {
		
		UsuarioLogin usuLogin = repo.buscaLogin(objDTO.getLogin(),objDTO.getIdSistema());
		
		if(usuLogin==null) {
			this.msg.add("Login inválido"); 
			throw new DataIntegrityException(String.join(",", this.msg)); 
			
		}
		
		objDTO.setId(usuLogin.getId());  
		
		String senhaCriptog = senhaCriptograda(objDTO,"L");  
		
		if(senhaCriptog.equals("OK")) { 
			senhaCriptog="" ;
			
		}
		
		if (!this.msg.isEmpty()) {					 
			throw new DataIntegrityException(String.join(",", this.msg)); 
	    }  
		return usuLogin;		
		
	 
	}
	
	
	@Transactional	
	 public void deletaUsuario(Long idUsuario,Long idSistema){	 
	 	  repo.deleteByIdUsuarioAndIdSistema(idUsuario, idSistema)  ;  
	}	
	
	@Transactional
	public UsuarioLogin insert (UsuarioLoginDTO objDTO) {  
		
		String senhaCriptog = senhaCriptograda(objDTO,"I");     
		
		if (!this.msg.isEmpty()) {					 
			throw new DataIntegrityException(String.join(",", this.msg)); 
	    } 	 
		
		 
		
		objDTO.setSenha(senhaCriptog);
		UsuarioLogin obj =  fromDTO(objDTO); 
		obj.setPerfil(2);
		
		return repo.save(obj);
	}
	
	
	@Transactional
	public UsuarioLogin update (UsuarioLoginDTO objDTO) throws UnsupportedEncodingException { 
		
		String senhaCriptog = senhaCriptograda(objDTO,"A");  
		
		if (!this.msg.isEmpty()) {					 
			throw new DataIntegrityException(String.join(",", this.msg)); 
	    } 	 
		
		objDTO.setSenha(senhaCriptog);
		UsuarioLogin obj =  fromDTO(objDTO);
		obj.setPerfil(2);
		
		return repo.save(obj);
	}
	
	
	
	@Transactional
	public UsuarioLogin trocaSenha (UsuarioLoginDTO objDTO) throws DataIntegrityException { 
		
		String senhaCriptog = senhaCriptograda(objDTO,"T");  
		
		if (!this.msg.isEmpty()) {					 
			throw new DataIntegrityException(String.join(",", this.msg)); 
	    } 	 
		
		objDTO.setSenha(senhaCriptog);
		UsuarioLogin obj =  fromDTO(objDTO);
		obj.setPerfil(2);
		
		return repo.save(obj);
	}	
 
	 private String senhaCriptograda(UsuarioLoginDTO obj, String operacao) {			 
		 this.msg.clear();
		 String senhaMD5 ="";
		 
			try {    
				SistemaSeg sistemaSeg =  sistemaService.findById(obj.getIdSistema());
				if(operacao.equals("I")){  	  
	        		  senhaMD5 = URL.criptografaMD5(obj.getSenha());  					
					
				}else { 
				
				    UsuarioLogin usuarioLogin = findById(obj.getId()); 
					if(sistemaSeg!=null) {
						
				         if(sistemaSeg.getTipoCodificacaoSenha().equals("M")) {	 	        	 
				        	 
				        	 if(operacao.equals("A")) { 
					        	 if(!(usuarioLogin.getSenha().equals(obj.getSenha()))) {	  
					        		 senhaMD5 = URL.criptografaMD5(obj.getSenha());   
					        	 }else {
					        		 senhaMD5 =  obj.getSenha() ;  
					        	 }
					        	 	 
					        
					         }else if(operacao.equals("T")) {
					        	 
				        	     String senhaAtualMD5 = URL.criptografaMD5(obj.getSenhaAnterior());  
				        	     
					        	 if(!(usuarioLogin.getSenha().equals(senhaAtualMD5))) {	
					        		 this.msg.add("Senha atual não confere."); 
					        	 }else{
					        		 senhaMD5 = URL.criptografaMD5(obj.getSenha());  
					        	 }
					         }else if(operacao.equals("L")) {
					        	 
				        	     String senhaAtualMD5 = URL.criptografaMD5(obj.getSenha());  
				        	     
					        	 if(!(usuarioLogin.getSenha().equals(senhaAtualMD5))) {	
					        		 this.msg.add("login ou senha não confere."); 
					        	 }else{
					        		 senhaMD5 = "OK";  
					        	 }
					         }
					         else {
					        	 this.msg.add("Operação não identificada.");
					         }
				        	 
				        }else {
				        	this.msg.add("Erro de gravação.");
				        }
					}else {
						this.msg.add("Tamanho do campo codigo invalido.");
					}
				}	
				
			}			
			catch (Exception e) {	
				this.msg.add(e.getMessage());
			}
		 
			return senhaMD5; 	
      } 
	 
	  public UsuarioLogin fromDTO(UsuarioLoginDTO objDTO) {
			return new UsuarioLogin(
					objDTO.getId(),
					objDTO.getIdUsuario(),
					objDTO.getIdSistema(),
					objDTO.getLogin(),
					objDTO.getSenha()
					);
     }		 
		

 
		
		
		
		
		
	
	
}
