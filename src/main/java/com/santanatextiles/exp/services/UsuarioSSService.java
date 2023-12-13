package com.santanatextiles.exp.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.santanatextiles.exp.domain.UsuarioLogin;
import com.santanatextiles.exp.domain.UsuarioSS;
import com.santanatextiles.exp.domain.DTO.UsuarioLoginDTO;
import com.santanatextiles.exp.domain.enums.PerfilUsuario;
import com.santanatextiles.exp.resources.exceptions.ObjectNotFoundException;



@Service
public class UsuarioSSService implements UserDetailsService {
	
	@Autowired
	private static final BCryptPasswordEncoder pe = new BCryptPasswordEncoder(); 
	
	@Autowired
	private UsuarioLoginService usuarioLoginService;
	
	@Value("${spring.datasource.url}") 
	private String JDBC_URL;
	
	@Value("${spring.datasource.username}")
	private String JDBC_USER;

	@Value("${spring.datasource.password}")
	private String JDBC_PASSWORD;
	
	private ArrayList<String> msg = new ArrayList<>();
	
	@Override
	public UserDetails loadUserByUsername(String codigo) throws UsernameNotFoundException {
		
		this.msg.clear();

		// O código é composto por Filial, Login e Sistema
		String[] usernameAndCustomToken = codigo.split("@");

        if (Objects.isNull(usernameAndCustomToken)) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        Long id    			   = Long.valueOf(0);
        String codigoUsuario 	= usernameAndCustomToken[1].trim();
        String sistema       	= usernameAndCustomToken[2].trim();
        String idfil         	= usernameAndCustomToken[3].trim();
		
		Set<PerfilUsuario> perfil = new HashSet<PerfilUsuario>();		
		UsuarioLoginDTO objUsuDTO = new UsuarioLoginDTO();
		
		objUsuDTO.setLogin(codigoUsuario);
		objUsuDTO.setIdSistema( Long.parseLong(sistema));   
		 		
		//UsuarioLogin objUsuarioLogin = usuarioLoginService.findByLoginAndIdSistema(objUsuDTO);
		
		UsuarioLogin objUsuarioLogin = usuarioLoginService.buscaLoginSys(codigoUsuario,Long.parseLong(sistema));
		
		if(objUsuarioLogin != null) {
			
			perfil.add(objUsuarioLogin.getPerfil());
			
			String senhaBCryptografada = pe.encode(objUsuarioLogin.getSenha()); 
			 
			if (objUsuarioLogin.getLogin() == null) {
				this.msg.add("Usuário Não Cadastrado.");
			}
			
			if (!this.msg.isEmpty()) {
				throw new ObjectNotFoundException(String.join(",", this.msg)); 
			}	 
			
			return new UsuarioSS(
					idfil,
					objUsuarioLogin.getLogin(),  
					objUsuarioLogin.getLogin(),
					objUsuarioLogin.getFkUsuario().getNome(), 
					senhaBCryptografada,
					objUsuarioLogin.getPerfil().getCodigo(),
					perfil,
					Long.parseLong(sistema),
					objUsuarioLogin.getIdUsuario() 
				 
					);			
			 
			
		}  else {
			
			throw new ObjectNotFoundException("Erro classe UsuarioSS. Login inválido."); 
		}

		

		
	}
	
	/*
	public UsuarioSS verificaLogin(String codigo, String senha, String idfil, String tipoUsuario) throws ObjectNotFoundException, UnsupportedEncodingException {
		
		this.msg.clear();
		
		boolean isPorteiro = false;
		boolean isGerente = false;
		
		Porteiro objPorteiro = porteiroService.buscar(idfil , codigo);
		 
		if(objPorteiro != null) {
			
			isPorteiro = true;
			
			ExpApplication._USUARIO.setIdfil(objPorteiro.getIdfil());
			ExpApplication._USUARIO.setCodigo(objPorteiro.getCodigo());
			ExpApplication._USUARIO.setLogin(objPorteiro.getNome());
			ExpApplication._USUARIO.setNome(objPorteiro.getNome());
			ExpApplication._USUARIO.setSenha(objPorteiro.getSenha());
			ExpApplication._USUARIO.setTipoUsuario(TipoUsuario.PORTEIRO);
			ExpApplication._USUARIO.setPerfil(objPorteiro.getPerfil());
			ExpApplication._USUARIO.setGerente(isGerente);
			ExpApplication._USUARIO.setPorteiro(isPorteiro);
			
		}
		
		
		
		if (ExpApplication._USUARIO.getLogin() == null) {
			this.msg.add("Usuário Não Cadastrado.");
		}
		
		if (!URL.verificaSenha(ExpApplication._USUARIO.getSenha(), senha)) {
			this.msg.add("Senha Inválida.");
		}
		
		if (!this.msg.isEmpty()) {
			throw new ObjectNotFoundException(String.join(",", this.msg)); 
		}

		return ExpApplication._USUARIO;
		
	}
	
	*/
	 
	
	public static UsuarioSS authenticated() {
		try {
			return (UsuarioSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}
