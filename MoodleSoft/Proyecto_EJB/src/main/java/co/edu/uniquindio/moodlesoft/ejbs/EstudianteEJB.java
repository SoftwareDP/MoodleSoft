package co.edu.uniquindio.moodlesoft.ejbs;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.uniquindio.moodlesoft.entidades.Estudiante;
import co.edu.uniquindio.moodlesoft.entidades.Profesor;

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
	
	public List listarEstudiantes(){
		List<Estudiante> x =dao.ejecutarNamedQuery(Estudiante.LISTAESTUDIANTES);
		return x;
	}
	
	public void eliminarEstudiante(Estudiante obj){
		 dao.eliminar(obj);
	}
	

	public boolean editarUsuario(Estudiante usuario) {
		if (dao.buscar(usuario.getIdUsuario()) != null) {
			dao.editar(usuario);
			return true;
		}
		return false;
	}

}