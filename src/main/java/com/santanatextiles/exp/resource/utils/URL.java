package com.santanatextiles.exp.resource.utils; 

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.santanatextiles.exp.resources.exceptions.DataIntegrityException;

public class URL {
	
	@Autowired
	private static final BCryptPasswordEncoder pe = new BCryptPasswordEncoder();	
	
	
	public static Long codigoLocalizacao(String idfil) {
		
		Long localizacao = Long.valueOf(1);
		
		switch (idfil) {
		case "01": 
			localizacao = Long.valueOf(1) ;
			break;
		case "03": 
			localizacao = Long.valueOf(1) ;
			break;
		case "05": 
			localizacao = Long.valueOf(2) ;
			break;
		case "06": 
			localizacao = Long.valueOf(4) ;
			break;
		case "20": 
			localizacao = Long.valueOf(1) ;
			break;
		default:
			throw new IllegalArgumentException("Código de localização não encontrado: " + idfil);
		}
		
		return localizacao;
		
		 
		
	}
	
	
	
	public static String criptografaMD5(String senha) throws UnsupportedEncodingException  {
		
		String result = "";
		
		try {
			
			MessageDigest md;
			md = MessageDigest.getInstance("MD5");
			md.update(senha.getBytes("UTF-8"));
			BigInteger hash = new BigInteger(1, md.digest());
			result = hash.toString(16);
			if ((result.length() % 2) != 0) {
			  result = "0" + result;
			}
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}	
	
	
	public static String senhaBCryptografada(String senha) throws UnsupportedEncodingException {
		
		try {		
	         String senhaAtualMD5 = criptografaMD5(senha);  
	     
		   	 if(!senha.equals(senhaAtualMD5)) {	
		   		throw new DataIntegrityException("Senha inválida.");  
		   	 }		
		   	 
		   	 
		} catch (Exception e) {
			e.printStackTrace();
		}	   	  
		
		return pe.encode(senha); 
		
	}	
	
	

}
