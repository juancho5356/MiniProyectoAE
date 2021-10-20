package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;
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
    	TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u",Usuario.class);
    	return query.getResultList();
    }
}