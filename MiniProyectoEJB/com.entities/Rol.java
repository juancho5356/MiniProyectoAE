package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


/**
 * The persistent class for the "ROLES" database table.
 * 
 */
@Entity
@Table(name="\"ROLES\"")
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROLES_IDROL_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLES_IDROL_GENERATOR")
	@Column(name="ID_ROL", unique=true, nullable=false, precision=38)
	private long idRol;

	@Column(length=100)
	private String descripcion;

	@Column(length=50)
	private String nombre;

	//bi-directional many-to-many association to Funcionalidad
	@ManyToMany
	@JoinTable(
		name="ROL_FUNCION"
		, joinColumns={
			@JoinColumn(name="ID_ROL", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_FUNCION", nullable=false)
			}
		)
	private List<Funcionalidad> funcionalidades;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="rol")
	private List<Usuario> usuarios;

	public Rol() {
	}

	public long getIdRol() {
		return this.idRol;
	}

	public void setIdRol(long idRol) {
		this.idRol = idRol;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Funcionalidad> getFuncionalidades() {
		return this.funcionalidades;
	}

	public void setFuncionalidades(List<Funcionalidad> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setRol(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setRol(null);

		return usuario;
	}

}