package co.edu.uniquindio.moodlesoft.ejbs;

import java.io.Serializable;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import co.edu.uniquindio.moodlesoft.ejbs.EJBGenerico;
import co.edu.uniquindio.moodlesoft.entidades.Tema;

@Stateless
@LocalBean
public class TemaEJB extends EJBGenerico<Tema> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void setClase(Class<Tema> clase) {
		dao.setClase(clase);
	}

	@PostConstruct
	public void init() {
		super.init();
		setClase(Tema.class);
	}

	/**
	 * Metodo que permite la persistencia de un Tema en la base de datos
	 * 
	 * @param pTema
	 *            El tema a persistir
	 */
	public boolean crearTema(Tema pTema) {
		if (buscarTema(pTema.getNombre()) == null) {
			dao.crear(pTema);
			return true;
		}
		return false;
	}

	/**
	 * Eliminar tema con datos que esten en el tema
	 */
	public boolean eliminarTema(Tema tema) {
		if (dao.buscar(tema) != null) {
			dao.eliminar(tema);
			return true;
		} else {
			return false;
		}

	}

	public boolean editarTema(Tema tema) {
		if (buscarTema(tema.getNombre()) != null) {
			dao.editar(tema);
			return true;
		}
		return false;
	}

	/**
	 * Metodo para buscar tema por nombre
	 * 
	 * @param nombre
	 *            Nombre del tema a buscar
	 * @return El tema correspondiente al parametro de buscaqueda
	 */
	public Tema buscarTema(String nombre) {
		List<Tema> res = dao.ejecutarNamedQuery(Tema.BUSCARPORNOMBRE, nombre);
		return res.size() == 0 ? null : res.get(0);
	}

	public List listarTemas() {
		return dao.ejecutarNamedQuery(Tema.BUSCAR_TEMAS);
	}

}
