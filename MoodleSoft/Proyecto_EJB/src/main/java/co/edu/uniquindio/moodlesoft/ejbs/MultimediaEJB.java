package co.edu.uniquindio.moodlesoft.ejbs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import co.edu.uniquindio.moodlesoft.ejbs.EJBGenerico;
import co.edu.uniquindio.moodlesoft.entidades.Multimedia;

@Stateless
@LocalBean
public class MultimediaEJB extends EJBGenerico<Multimedia>implements Serializable {

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
	public boolean crearMultimedia(Multimedia multimedia) {
		if (buscarMultimedia(multimedia.getNombre()) == null) {
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

	public List<Multimedia> getListaMultiediaPDF(int idTema) {

		List<Multimedia> res = dao.ejecutarNamedQuery(Multimedia.BUSCAR_MULTIMEDIA, idTema);
		List<Multimedia> pdf = new ArrayList<>();
		for (int i = 0; i < res.size(); i++) {
			if (res.get(i).getTipo().equals("PDF")) {
				System.out.println("entra pdf");
				pdf.add(res.get(i));
			}

		}
		return res.size() == 0 ? null : pdf;
	}
	
	public List<Multimedia> getListaMultiediaYoutube(int idTema) {

		List<Multimedia> res = dao.ejecutarNamedQuery(Multimedia.BUSCAR_MULTIMEDIA, idTema);
		List<Multimedia> pdf = new ArrayList<>();
		for (int i = 0; i < res.size(); i++) {
			if (res.get(i).getTipo().equals("youtube")) {
				pdf.add(res.get(i));
			}

		}
		return res.size() == 0 ? null : pdf;
	}
	
	public List<Multimedia> getListaMultiediaVideo(int idTema) {

		List<Multimedia> res = dao.ejecutarNamedQuery(Multimedia.BUSCAR_MULTIMEDIA, idTema);
		List<Multimedia> video = new ArrayList<>();
		for (int i = 0; i < res.size(); i++) {
			if (res.get(i).getTipo().equals("video")) {
				video.add(res.get(i));
			}

		}
		return res.size() == 0 ? null : video;
	}

	public void setListaMultiedia(List<Multimedia> listaMultiedia) {
		this.listaMultiedia = listaMultiedia;
	}

}