package co.edu.uniquindio.moodlesoft.bean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import co.edu.uniquindio.moodlesoft.ejbs.EstudianteEJB;
import co.edu.uniquindio.moodlesoft.ejbs.UsuarioEJB;
import co.edu.uniquindio.moodlesoft.entidades.Estudiante;
import co.edu.uniquindio.moodlesoft.entidades.Usuario;

@ManagedBean(name = "estudianteBean")
@ViewScoped
public class EstudianteBean {
	private Estudiante estudiante;
	@ManagedProperty(value = "#{util}")
	private UtilBean util;
	private Usuario usuario = new Usuario();
	private String repass;

	@EJB
	private EstudianteEJB estudianteEJB;

	@EJB
	private UsuarioEJB usuarioEJB;

	@PostConstruct
	public void init() {
		estudiante = new Estudiante();
	}

	/**
	 * Metodo que permite ingresar un registro a la base de datos, en la tabla
	 * Tema
	 */
	public void registrarTema() {
		estudianteEJB.crear(estudiante);
		limpiarCampos();
	}

	public void registrarEstudiante() {
		if (estudiante.getContrasena().equals(repass)) {
			if (estudianteEJB.registrarEstudiante(estudiante)) {
                util.info("Registro exitoso", "Completado");
                limpiarCampos();
            }
            else{
                util.error("Error. Intentelo de nuevo mas tarde", "Error interno al agregar");
            }
 
		} else {
			util.error("Las contraseñas no coinciden", "Verifique las contraseñas");
		}

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
	 * @param estudiante
	 *            the estudiante to set
	 */
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public String getRepass() {
		return repass;
	}

	public void setRepass(String repass) {
		this.repass = repass;
	}

	public UtilBean getUtil() {
		return util;
	}

	public void setUtil(UtilBean util) {
		this.util = util;
	}
	
	

}