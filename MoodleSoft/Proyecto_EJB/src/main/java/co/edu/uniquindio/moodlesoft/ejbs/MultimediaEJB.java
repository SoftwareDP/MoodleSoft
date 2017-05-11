package co.edu.uniquindio.moodlesoft.ejbs;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import co.edu.uniquindio.moodlesoft.ejbs.EJBGenerico;
import co.edu.uniquindio.moodlesoft.entidades.Multimedia;
import co.edu.uniquindio.moodlesoft.entidades.Tema;

@Stateless
@LocalBean
public class MultimediaEJB extends EJBGenerico<Multimedia> implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private List<Multimedia> listaMultiedia;
	
	@Override
	public void setClase(Class<Multimedia> clase) {
		dao.setClase(clase);
	}

	@PostConstruct
	public void init() {
		super.init();
		setClase(Multimedia.class);
	}
	

	/**
	 * Metodo que permite la persistencia de un Multimedia en la base de datos
	 * 
	 * @param multimedia
	 *            El video o PDF a persistir
	 */
	public boolean crearMultimedia(Multimedia multimedia, Tema tema) {
		if (buscarMultimedia(multimedia.getNombre()) == null) {
			multimedia.setTema(tema);
			dao.crear(multimedia);
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
	public String buscarMultimedia(String nombre) {
		List<Multimedia> res = dao.ejecutarNamedQuery(Multimedia.BUSCARPORNOMBRE, nombre);
		return res.size() == 0 ? null : res.get(0).getDireccion().toString();
	}

	public List<Multimedia> getListaMultiedia() {
		return listaMultiedia;
	}

	public void setListaMultiedia(List<Multimedia> listaMultiedia) {
		this.listaMultiedia = listaMultiedia;
	}
	
	
}
