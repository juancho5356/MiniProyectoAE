package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.entities.Funcionalidad;

/**
 * Session Bean implementation class FuncionalidadBean
 */
@Stateless
public class FuncionalidadBean implements FuncionalidadBeanRemote {

	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public FuncionalidadBean() {
    }

    @Override
    public List<Funcionalidad> mostrarTodos() {
    	TypedQuery<Funcionalidad> query = em.createNamedQuery("Funcionalidad.findAll",Funcionalidad.class);
    	return query.getResultList();
    }
}
