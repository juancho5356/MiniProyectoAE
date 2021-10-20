package com.servicios;

import java.util.List;
import com.entities.*;
import javax.ejb.Remote;

@Remote
public interface FuncionalidadBeanRemote {

	List<Funcionalidad> mostrarTodos();
}
