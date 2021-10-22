package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Rol;
import com.entities.Usuario;
import com.exception.ServiciosException;

@Remote
public interface UsuarioBeanRemote {

	void crear(Usuario usuario) throws ServiciosException;
	void actualizar(Usuario usuario) throws ServiciosException;
	void borrar(Long documento) throws ServiciosException;
	List<Usuario> mostrarTodos();
	List<Usuario> findRol(Rol rol);
	List<Usuario> findUsuario(String correo, String contraseña);
}
