package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.entities.Rol;

/**
 * Session Bean implementation class RolBean
 */
@Stateless
public class RolBean implements RolBeanRemote {

	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public RolBean() {
        
    }

    public List<Rol> mostrarTodos() {
    	TypedQuery<Rol> query = em.createQuery("SELECT r FROM Rol r",Rol.class);
    	return query.getResultList();
    }
}
