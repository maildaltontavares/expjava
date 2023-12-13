package com.santanatextiles.exp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.santanatextiles.exp.domain.UsuarioSeg;
@Repository
public interface UsuarioSegRepository extends JpaRepository<UsuarioSeg, Long>{
	
	List<UsuarioSeg> findByNomeContains(String nome);
	
    @Query(value = "Select 	ID ,"
    		+ "IDFIL,"
    		+ "NOME,"
    		+ "EMAIL" 
    		+ " from seg.usuario u "+
    	    " where upper(trim(NOME)) like '%' ||?1 || '%' order by NOME",nativeQuery = true)
      List<UsuarioSeg> buscaUsuarioPorNome(@Param("nome") String nome) ; 	
	
	 

}