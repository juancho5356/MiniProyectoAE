package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;

import com.entities.Rol;
import com.entities.Usuario;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class UsuarioBean
 */
@Stateless
public class UsuarioBean implements UsuarioBeanRemote {

	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public UsuarioBean() {
        
    }

    public void crear(Usuario usuario) throws ServiciosException {
        
        try{
        	em.persist(usuario);
        	em.flush();
        
        }catch(PersistenceException e){
        	throw new ServiciosException("No se pudo crear el usuario");
        	
         }
    }
    
    public void actualizar(Usuario usuario) throws ServiciosException {
        try{
        	em.merge(usuario);
        	em.flush();
        	
         }catch(PersistenceException e){
        	 throw new ServiciosException("No se pudo actualizar el usuario");
        	 
         }
    }
    
    public void borrar(Long id) throws ServiciosException {
    	try{
    	Usuario usuario = em.find(Usuario.class, id);
   		em.remove(usuario);
    	em.flush();
    
    	}catch(PersistenceException e){
    		throw new ServiciosException("No se pudo borrar el usuario");
    	}
    } 
    
    public List<Usuario> mostrarTodos() {
    	TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findAll",Usuario.class);
    	return query.getResultList();
    }
    
    public List<Usuario> findRol(Rol rol){
    	TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.rol = ?1", Usuario.class).setParameter(1, rol);
    	return query.getResultList();
    }
    
    public List<Usuario> findUsuario(String correo, String contraseña) {
    	TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.mail = ?1 AND u.clave = ?2", Usuario.class).setParameter(1, correo).setParameter(2, contraseña).setMaxResults(1);
    	return query.getResultList();
    }
}