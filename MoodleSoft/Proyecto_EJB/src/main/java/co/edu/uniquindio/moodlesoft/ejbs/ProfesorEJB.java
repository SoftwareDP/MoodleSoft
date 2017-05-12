package co.edu.uniquindio.moodlesoft.ejbs;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.uniquindio.moodlesoft.entidades.Estudiante;
import co.edu.uniquindio.moodlesoft.entidades.Profesor;
import co.edu.uniquindio.moodlesoft.entidades.Usuario;

@Stateless
@LocalBean
public class ProfesorEJB extends EJBGenerico<Profesor>implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void setClase(Class<Profesor> clase) {
		dao.setClase(clase);
	}

	@PostConstruct
	public void init() {
		super.init();
		setClase(Profesor.class);
	}


	public boolean editarUsuario(Profesor usuario) {
		if (dao.buscar(usuario.getIdUsuario()) != null) {
			dao.editar(usuario);
			return true;
		}
		return false;
	}

}
