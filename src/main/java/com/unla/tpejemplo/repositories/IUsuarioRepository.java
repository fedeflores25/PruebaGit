package com.unla.tpejemplo.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.tpejemplo.entities.Usuario;

@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable>{

	@Query("SELECT u FROM Usuario u JOIN FETCH u.usuarioRol WHERE u.username = (:username)")
	public abstract Usuario findByUsernameAndFetchUsuarioRolEagerly(@Param("username") String username);
	
}
