package co.edu.uniquindio.moodlesoft.ejbs;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import co.edu.uniquindio.moodlesoft.entidades.Estudiante;
import co.edu.uniquindio.moodlesoft.entidades.Profesor;
import co.edu.uniquindio.moodlesoft.entidades.Tema;
import co.edu.uniquindio.moodlesoft.entidades.Usuario;

@Stateless
@LocalBean
public class UsuarioEJB extends EJBGenerico<Usuario>implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void setClase(Class<Usuario> clase) {
		dao.setClase(clase);
	}

	@PostConstruct
	public void init() {
		super.init();
		setClase(Usuario.class);
	}

	public Usuario validarLogin(String correo, String password, String tipoUsuario) {
		if (tipoUsuario.equals("Profesor")) {
			List<Usuario> res = dao.ejecutarNamedQuery(Profesor.LOGINPROFESOR, correo, password);
			return res.size() == 0 ? null : res.get(0);
		} else {
			List<Usuario> res = dao.ejecutarNamedQuery(Estudiante.LOGINESTUDIANTE, correo, password);
			return res.size() == 0 ? null : res.get(0);
		}
	}

	public boolean editarUsuario(Usuario usuario) {
		if (dao.buscar(usuario.getIdUsuario()) != null) {
			dao.editar(usuario);
			return true;
		}
		return false;
	}

}
