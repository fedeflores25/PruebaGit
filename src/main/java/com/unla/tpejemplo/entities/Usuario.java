package com.unla.tpejemplo.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	
	@Column(name="username", unique=true, nullable=false, length=50)
	private String username;
	
	@Column(name="password", nullable=false, length=60)
	private String password;
	
	@Column(name="activo")
	private boolean activo;
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	//muchos usuarios pueden tener el mismo rol
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="usuarioRol_id", nullable=false)
	private UsuarioRol usuarioRol;

	public Usuario() {}

	public Usuario(int idUsuario, String username, String password, boolean activo, UsuarioRol usuarioRol) {
		this.idUsuario = idUsuario;
		this.username = username;
		this.password = password;
		this.activo = activo;
		this.usuarioRol = usuarioRol;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	protected void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public UsuarioRol getUsuarioRol() {
		return usuarioRol;
	}

	public void setUsuarioRol(UsuarioRol usuarioRol) {
		this.usuarioRol = usuarioRol;
	}
	
	
	
	
	
}
