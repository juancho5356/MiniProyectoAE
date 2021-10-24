package com.servicios;

import java.util.List;
import model.*;
import javax.ejb.Remote;


@Remote
public interface Funcionalidad_BeanRemote {

	List<Funcionalidad> mostrarTodos();

}
