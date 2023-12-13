package com.santanatextiles.exp.repositories;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.exp.domain.UsuarioLogin;


@Repository
public interface UsuarioLoginRepository extends JpaRepository<UsuarioLogin, Long>{  
	
	Optional<UsuarioLogin> findByIdUsuarioAndIdSistema(Long idUsuario,Long idSistema); 
	
   @Query(value =  
		      "Select ID,  "
		      + "USUARIO_ID,"
		      + "SISTEMA_ID,"
		      + "LOGIN,"
		      + "SENHA , "  
		      + "PERFIL_JWT   " +
		      " from seg.usuario_login " +
		      " where trim(login) = ?1 and sistema_id = ?2",nativeQuery = true)
   UsuarioLogin buscaLogin(String login,Long idSistema) ; 	
	
	
	@Transactional
	Long deleteByIdUsuarioAndIdSistema(Long idUsuario,Long idSistema); 
	
	@Transactional
	UsuarioLogin findByLoginAndIdSistema(String login,Long idSistema);  
	
	
	@Query(value = ""+
	"select sistema_id sistema, sis.descricao desc_sistema, usu.id id_usu,usu.nome nome_usu, ul.login, sis.sigla "
	+ "  from seg.usuario_login ul "
	+ "inner join seg.sistema sis on  sis.ID = ul.SISTEMA_ID "
	+ " inner join seg.usuario usu on usu.ID = ul.USUARIO_ID "
	+ " where  "
	+ " (:idSistema ='0'  OR trim(to_char(ul.sistema_id)) = :idSistema )   and "  
	+ " (:nomeUsuario IS NULL OR UPPER(trim(usu.nome)) like '%' ||:nomeUsuario || '%' )   and "  
	+ " (:login IS NULL OR UPPER(trim(ul.login)) like '%' || :login || '%' )   "  
	+ " order by sis.descricao,usu.nome "
	,nativeQuery = true)		
	List<Map<String, Object>> buscaSistemaUsuario(
	@Param("idSistema") String idSistema ,
	@Param("nomeUsuario") String nomeUsuario , 
	@Param("login")  String login    
	);		
	
	
}
