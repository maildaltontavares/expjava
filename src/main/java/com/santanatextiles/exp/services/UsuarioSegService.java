package com.santanatextiles.exp.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.exp.domain.UsuarioSeg;
import com.santanatextiles.exp.repositories.UsuarioSegRepository;



@Service
public class UsuarioSegService {
	
	@Autowired
	private UsuarioSegRepository repo;	
	
	
	@Value("${spring.datasource.url}")
	private String JDBC_URL;
	
	@Value("${spring.datasource.username}")
	private String JDBC_USER;

	@Value("${spring.datasource.password}")
	private String JDBC_PASSWORD;		
	
	public List<UsuarioSeg> findByNome(String nome){   
		String nomeUsuario = nome.toUpperCase();
		return repo.findByNomeContains(nomeUsuario);
	}
	
	
	public List<UsuarioSeg> buscaUsuarioPorNome(String nome){  		
		String nomeUsuario = nome.toUpperCase();
		return repo.buscaUsuarioPorNome(nomeUsuario);
	}	
	
	public UsuarioSeg findById(Long id) {
		Optional<UsuarioSeg> usuarioSeg = repo.findById(id);
		return usuarioSeg.orElse(null);
	}
	
	public List<UsuarioSeg> findAll(){  
		return repo.findAll();
	}
	
	@Transactional
	public void deleteById(Long id) {		 
		repo.deleteById(id);
		return;
	}	
	
	
	@Transactional
	public UsuarioSeg insert(UsuarioSeg u) {		 
		UsuarioSeg usu = repo.save(u);
		return usu;
	}	
	
	@Transactional
	public UsuarioSeg update(UsuarioSeg u) {		 
		UsuarioSeg usu = repo.save(u);
		return usu;
	}	
	
	
	
	 
    public JSONArray  usuarioPermissao( String sistema, String usuario) throws SQLException {

         JSONArray lista = new JSONArray();
         
         try {
               
                Connection myConnection=DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
    
	             Statement sqlStatement = (Statement) myConnection.createStatement(); 
	             
             String readRecordSQL = ""   
             		     + "        SELECT  usu.id as usuario_id,"
	                     + "        usu.nome as nome,"
	                     + "        sis.sigla as sistema_sigla,"
	                     + "        sis.id as sistema_id,"
	                     + "        pag.id as pagina_id,"
	                     + "        pag.sigla as pagina_sigla,"
	                     + "        pag.requerautenticacao,"
	                     + "        per.acesso as acesso,"
	                     + "        per.modificar as modificar"
	                     + "        FROM   seg.usuario usu,"
	                     + "        seg.sistema sis,"
	                     + "        seg.pagina pag,"
	                     + "        seg.permissao_usuario per,"
	                     + "        seg.usuario_login usl "	  
	                     + "        WHERE   per.usuario_id = usu.id "
	                     + "        AND per.pagina_id = pag.id "
	                     + "        AND pag.sistema_id = sis.id "
	                     + "        AND usl.usuario_id = usu.id "
	                     + "        AND usl.sistema_id = pag.sistema_id "   	                     
	                     + "        AND sis.sigla = '"+sistema.trim()+"'"
	                     + "        AND usl.login = '"+usuario.trim()+"'" 	     
	                     
             		     + "        union all   "  
             		     
             		     + "        SELECT  usu.id as usuario_id,     "  
             		     + "        usu.nome as nome,     "  
             		     + "        sis.sigla as sistema_sigla,    "  
             		     + "        sis.id as sistema_id,     "  
             		     + "        pag.id as pagina_id,     "  
             		     + "        pag.sigla as pagina_sigla,     "  
             		     + "        pag.requerautenticacao,      "  
             		     + "        per.acesso as acesso,     "  
             		     + "        per.modificar as modificar     "  
             		     + "        FROM   seg.usuario usu,     "  
             		     + "        seg.sistema sis,    "  
             		     + "        seg.pagina pag,    "  
             		     + "        seg.grupo grupo,    "  
             		     + "        seg.usuario_grupo ug ,    "  
             		     + "        seg.permissao_grupo per ,  "  
             		     + "        seg.usuario_login usl     " 
             		     + "        WHERE     "  
             		     + "        usu.id = ug.usuario_id "  
             		     + "        AND ug.grupo_id = grupo.id "  
             		     + "        AND grupo.id = per.grupo_id  " 
             		     + "        AND per.pagina_id = pag.id "  
             		     + "        AND pag.sistema_id = sis.id  "  
             		     + "        AND usl.usuario_id = usu.id 	   " 
             		     + "        AND usl.sistema_id = pag.sistema_id " 
	                     + "        AND sis.sigla = '"+sistema.trim()+"'"
	                     + "        AND usl.login = '"+usuario.trim()+"'"; 	    

	             
	             ResultSet resultSet = ((java.sql.Statement) sqlStatement).executeQuery(readRecordSQL); 
	             
	             ResultSetMetaData md = resultSet.getMetaData();
	             
	             int numCols = md.getColumnCount();
	             List<String> colNames = IntStream.range(0, numCols)
	               .mapToObj(i -> {
	                   try {
	                       return md.getColumnName(i + 1);
	                   } catch (SQLException e) {
	                       e.printStackTrace();
	                       return "?";
	                   }
	               })
	               .collect(Collectors.toList());

	             while (resultSet.next()) {
	                
	                 JSONObject row = new JSONObject();
	                 
	                 colNames.forEach(cn -> {
	                     try {
	                         row.put(cn, resultSet.getObject(cn));
	                     } catch (JSONException | SQLException e) {
	                         e.printStackTrace();
	                     }
	                 });
	                 
	                 lista.put(row);
	             }  
	             
	             myConnection.close();
	             
	          } catch (Exception e) {
	                System.out.println(e);
	          }
	          
	          return lista;
         
    }	
	
	

}
