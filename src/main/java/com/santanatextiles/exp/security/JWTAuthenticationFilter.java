package com.santanatextiles.exp.security;

 

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.santanatextiles.exp.domain.UsuarioSS;
import com.santanatextiles.exp.domain.DTO.CredenciaisDTO;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private AuthenticationManager authenticationManager;
	
	private JWTUtil jwtUtil;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
		setAuthenticationFailureHandler(new JWTAuthenticationFailureHandler());
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}
	
	private class JWTAuthenticationFailureHandler implements AuthenticationFailureHandler {
		 
        @Override
        public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
                throws IOException, ServletException {
            response.setStatus(401);
            response.setContentType("application/json"); 
            response.getWriter().append(json());
        }
        
        private String json() {
            long date = new Date().getTime();
            return "{\"timestamp\": " + date + ", "
                + "\"status\": 401, "
                + "\"error\":Não autorizado\", "
                + "\"message\":Código ou senha inválidosxxx\", "
                + "\"path\":/login\"}";
        }
    }
	
	@Override
	public Authentication attemptAuthentication(
			HttpServletRequest req,
			HttpServletResponse res) throws AuthenticationException {
		
		try {
			
			CredenciaisDTO creds = new ObjectMapper()
					.readValue(req.getInputStream(), CredenciaisDTO.class);
			
			String customCodigo = String.format("%s%s%s%s%s%s%s",
					creds.getId(),
					"@",
					creds.getLogin(),
		            "@", 
		            creds.getIdSistema()
		            ,
		            "@", 
		            creds.getIdfil());
			
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(customCodigo, creds.getSenha(), new ArrayList<>());
			
			Authentication auth = authenticationManager.authenticate(authToken);
			
			return auth;
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	protected void successfulAuthentication(
			HttpServletRequest req,
			HttpServletResponse res,
			FilterChain chain,
			Authentication auth) throws IOException,ServletException {
		
		Long id = ((UsuarioSS) auth.getPrincipal()).getIdUsuario();
		String codigo = ((UsuarioSS) auth.getPrincipal()).getUsername();
		long sistema = ((UsuarioSS) auth.getPrincipal()).getSistema();
		String idfil = ((UsuarioSS) auth.getPrincipal()).getIdfil();
		
		String customCodigo = String.format("%s%s%s%s%s%s%s", 
				id, 
				"@",
				codigo, 
				"@", 
				sistema, 
				"@", 
				idfil);
		
		String token = jwtUtil.generateToken(customCodigo);
		
		res.addHeader("Authorization", "Bearer " + token);
		res.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		res.getOutputStream().print(new ObjectMapper().writeValueAsString(auth.getPrincipal()));
	}

}

