package com.santanatextiles.exp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.santanatextiles.exp.domain.UsuarioSS;

@SpringBootApplication
public class ExpApplication {
	
	public static UsuarioSS _USUARIO= new UsuarioSS();

	public static void main(String[] args) {
		SpringApplication.run(ExpApplication.class, args);
	}

}
