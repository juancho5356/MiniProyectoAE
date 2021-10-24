package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.exception.ServiciosException;

import model.Rol;

/**
 * Session Bean implementation class Rol_Bean
 */
@Stateless
public class Rol_Bean implements Rol_BeanRemote {

	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public Rol_Bean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Rol> findAll() {
		TypedQuery<Rol> query;
		query = em.createNamedQuery("Rol.findAll", Rol.class);
		return query.getResultList();
	}

	@Override
	public Rol findNombre(String nombre) throws ServiciosException {
		try {
    		TypedQuery<Rol> query = em.createQuery("SELECT r FROM Rol r WHERE r.nombre LIKE :nombre", Rol.class);
			query.setParameter("nombre", nombre);
			Rol r = query.getSingleResult();
    		return r;

    	}catch(Exception ex) {
    		ex.getMessage();
    		return null;
    	}
	}
	
	@Override
	public Rol findAcceso(String rol, String funcionalidad) throws ServiciosException{
		try {
			TypedQuery<Rol> query = em.createQuery("SELECT r FROM Rol r JOIN FETCH r.funcionalidades f WHERE r.nombre LIKE :rol AND f.nombre LIKE :funcionalidad", Rol.class);
			query.setParameter("rol", rol);
			query.setParameter("funcionalidad", funcionalidad);
			Rol r = query.getSingleResult();
			
			return r;
		}catch (Exception ex){
			ex.getMessage();
			return null;
		}
	}
	
	

}
