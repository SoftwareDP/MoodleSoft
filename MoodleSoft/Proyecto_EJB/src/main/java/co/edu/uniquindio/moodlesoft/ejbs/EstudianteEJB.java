package co.edu.uniquindio.moodlesoft.ejbs;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.uniquindio.moodlesoft.entidades.Estudiante;

@Stateless
@LocalBean
public class EstudianteEJB extends EJBGenerico<Estudiante>implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public void setClase(Class<Estudiante> clase) {
		dao.setClase(clase);
	}

	@PostConstruct
	public void init() {
		super.init();
		setClase(Estudiante.class);
	}

	/**
	 * Metodo que permite el registro de un estudiante en la base de datos
	 * 
	 * @param pEstudiante
	 *            El estudiante a persistir
	 */
	public boolean registrarEstudiante(Estudiante pEstudiante) {
		if (dao.buscar(pEstudiante.getIdUsuario()) == null) {
			dao.crear(pEstudiante);
			return true;
		}
		return false;
	}

}
