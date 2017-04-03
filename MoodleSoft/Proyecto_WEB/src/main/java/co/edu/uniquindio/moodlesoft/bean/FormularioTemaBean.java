package co.edu.uniquindio.moodlesoft.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import co.edu.uniquindio.moodlesoft.ejbs.TemaEJB;
import co.edu.uniquindio.moodlesoft.entidades.Tema;

@ManagedBean(name = "formularioTemaBean")
@ViewScoped
public class FormularioTemaBean {

	private List<Tema> temas;

	public Tema tema = new Tema();
	public Tema temaSeleccionado = new Tema();

	@Inject
	private TemaEJB temaEJB;

	@PostConstruct
	public void init() {
		temas = new ArrayList<>();
	}

	/**
	 * Metodo que permite ingresar un registro a la base de datos, en la tabla
	 * Tema
	 */
	public void registrarTema() {
		temaEJB.crearTema(tema);
		limpiarCampos();
	}
	
	
	public void modificarTema(){
		temaEJB.editarTema(temaSeleccionado);
		limpiarCampos();
	}

	/**
	 * Método que permite inicializar los atributos
	 */
	public void limpiarCampos() {
		tema = new Tema();
		temaSeleccionado = new Tema();
	}

	public void listaTemas() {
		temas = temaEJB.listarTemas();
	}

	public Tema getTema() {
		return tema;
	}

	public void mostrarInfoTema() {
		tema.setIdTema(temaSeleccionado.getIdTema());
		tema.setNombre(temaSeleccionado.getNombre());
		tema.setDescripcion(temaSeleccionado.getDescripcion());

	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	/**
	 * @return the temas
	 */
	public List<Tema> getTemas() {
		return temas;
	}

	/**
	 * @param temas
	 *            the temas to set
	 */
	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

	public Tema getTemaSeleccionado() {
		return temaSeleccionado;
	}

	public void setTemaSeleccionado(Tema temaSeleccionado) {
		this.temaSeleccionado = temaSeleccionado;
	}

}
