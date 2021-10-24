package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.exception.ServiciosException;

import model.Usuario;

/**
 * Session Bean implementation class Usuario_Bean
 */
@Stateless
public class Usuario_Bean implements Usuario_BeanRemote {

	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public Usuario_Bean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Usuario findUser(String correo, String contrasenia) throws ServiciosException {
		try {
    		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.mail LIKE :correo AND u.clave LIKE :contrasenia", Usuario.class);
			query.setParameter("correo", correo);
			query.setParameter("contrasenia", contrasenia);
			Usuario u = query.getSingleResult();
    		return u;

    	}catch(Exception ex) {
    		ex.getMessage();
    		return null;
    	}
	}

	@Override
	public Usuario findCorreo(String correo) throws ServiciosException {
		try {
    		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.mail LIKE :correo", Usuario.class);
			query.setParameter("correo", correo);
			Usuario u = query.getSingleResult();
    		return u;

    	}catch(Exception ex) {
    		ex.getMessage();
    		return null;
    	}
	}

	@Override
	public Usuario findDocumento(String documento) throws ServiciosException {
		try {
    		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.documento LIKE :documento", Usuario.class);
			query.setParameter("documento", documento);
			Usuario u = query.getSingleResult();
    		return u;

    	}catch(Exception ex) {
    		ex.getMessage();
    		return null;
    	}
	}

	@Override
	public boolean insert(Usuario usuario) throws ServiciosException {
		try {
    		em.persist(usuario);
    		em.flush();
    		return true;
    	}catch(Exception e) {
    		return false;
    	}
	}
	
	@Override
	public boolean delete(Usuario usuario) throws ServiciosException {
		try {
			usuario = em.find(Usuario.class, usuario.getIdUsuario());
			em.remove(usuario);
			em.flush();
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}
	
	@Override
	public boolean edit(Usuario usuario) throws ServiciosException {
		try {
			em.merge(usuario);
			em.flush();
			return true;
		}catch(Exception e) {
    		return false;
		}
	}
	
	@Override
	public List<Usuario> findAll(){
		TypedQuery<Usuario> query;
		query = em.createNamedQuery("Usuario.findAll", Usuario.class);
		return query.getResultList();
	}
	
	@Override
	public Usuario findId(Long id) throws ServiciosException{
		try {
    		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.idUsuario LIKE :id", Usuario.class);
			query.setParameter("id", id);
			Usuario u = query.getSingleResult();
    		return u;

    	}catch(Exception ex) {
    		ex.getMessage();
    		return null;
    	}
	}

}
