package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.ManyToOne;


/**
 * The persistent class for the USUARIOS database table.
 * 
 */
@Entity
@Table(name="USUARIOS")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIOS_IDUSUARIO_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIOS_IDUSUARIO_GENERATOR")
	@Column(name="ID_USUARIO", unique=true, nullable=false, precision=38)
	private long idUsuario;

	@Column(nullable=false, length=30)
	private String apellido;

	@Column(length=50)
	private String clave;

	@Column(nullable=false, length=20)
	private String documento;

	@Column(length=50)
	private String mail;

	@Column(nullable=false, length=30)
	private String nombre;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="ID_ROL")
	private Rol rol;

	public Usuario() {
	}

	public long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}