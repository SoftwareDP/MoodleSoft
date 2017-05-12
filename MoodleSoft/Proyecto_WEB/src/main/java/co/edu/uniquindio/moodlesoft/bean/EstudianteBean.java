package co.edu.uniquindio.moodlesoft.bean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import co.edu.uniquindio.moodlesoft.ejbs.EstudianteEJB;
import co.edu.uniquindio.moodlesoft.ejbs.UsuarioEJB;
import co.edu.uniquindio.moodlesoft.entidades.Estudiante;
import co.edu.uniquindio.moodlesoft.entidades.Usuario;

@ManagedBean(name = "estudianteBean")
@ViewScoped
public class EstudianteBean {
	private Estudiante estudiante = new Estudiante();
	private Usuario usuario = new Usuario();
	
	@EJB
	private EstudianteEJB estudianteEJB;
	
	@EJB
	private UsuarioEJB usuarioEJB;
	
	/**
	 * Metodo que permite ingresar un registro a la base de datos, en la tabla
	 * Tema
	 */
	public void registrarTema() {
		estudianteEJB.crear(estudiante);
		limpiarCampos();
	}
	
	public void modificarTema() {
		usuarioEJB.editarUsuario(usuario);
		limpiarCampos();
	}
	

	/**
	 * M�todo que permite inicializar los atributos
	 */
	public void limpiarCampos() {
		estudiante = new Estudiante();
		usuario = new Usuario();
	}


	/**
	 * @return the estudiante
	 */
	public Estudiante getEstudiante() {
		return estudiante;
	}

	/**
	 * @param estudiante the estudiante to set
	 */
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
	
	
}