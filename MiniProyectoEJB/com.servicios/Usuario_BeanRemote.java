package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.exception.ServiciosException;

import model.Usuario;

@Remote
public interface Usuario_BeanRemote {

	public Usuario findUser(String correo, String contrasenia) throws ServiciosException;
	
	public Usuario findCorreo(String correo) throws ServiciosException;
	
	public Usuario findDocumento(String documento) throws ServiciosException;
	
	public boolean insert(Usuario usuario) throws ServiciosException;

	boolean delete(Usuario usuario) throws ServiciosException;

	boolean edit(Usuario usuario) throws ServiciosException;
	
	public List<Usuario> findAll();

	Usuario findId(Long id) throws ServiciosException;
}

