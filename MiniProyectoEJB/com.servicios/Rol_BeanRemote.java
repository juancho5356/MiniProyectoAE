package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.exception.ServiciosException;

import model.Rol;

@Remote
public interface Rol_BeanRemote {
	

	public List<Rol> findAll();
	
	public Rol findNombre(String nombre) throws ServiciosException;

	Rol findAcceso(String rol, String funcionalidad) throws ServiciosException;

}
