package com.santanatextiles.exp.config;



import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.santanatextiles.exp.security.JWTAuthenticationFilter;
import com.santanatextiles.exp.security.JWTAuthorizationFilter;
import com.santanatextiles.exp.security.JWTUtil;



@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	private static final String[] PUBLIC_MATCHERS = { 
			"/exp/login"
	};
	
	@Value("${host.frontend}")
	private String hostFrontEnd;

	@Value("${aplicacao.comToken}")
	private boolean comToken;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationConfiguration authenticationManager;
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		/* Com JWT Token */
		if(comToken) {
			http.headers().addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", hostFrontEnd));
			http.cors();
			http.csrf()
	        	.disable()
	            .authorizeHttpRequests()
	            .anyRequest()
	            .authenticated();
	            
			http.addFilter(new JWTAuthenticationFilter(authenticationManager.getAuthenticationManager(), jwtUtil));
			http.addFilter(new JWTAuthorizationFilter(authenticationManager.getAuthenticationManager(), jwtUtil, userDetailsService));
			http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			
		} else {
			
			http.headers().addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", hostFrontEnd));
			http.cors();
			http.csrf()
	        	.disable()
	            .authorizeHttpRequests()
	            .anyRequest()
	            .permitAll();
	            
			http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			
		}
        
        return http.build();
    }
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList(hostFrontEnd));
		configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE"));
		configuration.addExposedHeader("*");
		configuration.setAllowCredentials(true);
		configuration.applyPermitDefaultValues();
		
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

}

