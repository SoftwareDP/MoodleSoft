package co.edu.uniquindio.moodlesoft.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.model.UploadedFile;

import co.edu.uniquindio.moodlesoft.ejbs.MultimediaEJB;
import co.edu.uniquindio.moodlesoft.ejbs.TemaEJB;
import co.edu.uniquindio.moodlesoft.entidades.Multimedia;
import co.edu.uniquindio.moodlesoft.entidades.Tema;

@ManagedBean(name = "formularioTemaBean")
@ViewScoped
public class FormularioTemaBean {

	private List<Tema> temas;

	private Tema tema = new Tema();
	private Tema temaSeleccionado = new Tema();
	private UploadedFile pdf;
	private Multimedia multimedia = new Multimedia();

	@Inject
	private TemaEJB temaEJB;

	@Inject
	private MultimediaEJB multimediaEJB;

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

	/**
	 * Metodo que permite modificar el contenido del tema creado
	 */
	public void modificarTema() {
		temaEJB.editarTema(temaSeleccionado);
		limpiarCampos();
	}

	/**
	 * Método que permite inicializar los atributos
	 */
	public void limpiarCampos() {
		tema = new Tema();
		temaSeleccionado = new Tema();
		multimedia = new Multimedia();
	}

	/**
	 * Metodo que permite listar los temas almacenados en la base de datos
	 */
	public void listaTemas() {
		temas = temaEJB.listarTemas();
	}

	/**
	 * Metodo que permite cargar el archivo pdf
	 */
	public void cargarPdf() {
		if (pdf != null) {
			FacesMessage message = new FacesMessage("Se cargo ", pdf.getFileName() + " correctamente.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public void guardarMultimedia() {
		multimediaEJB.crearMultimedia(multimedia, temaSeleccionado);
		limpiarCampos();
	}

	/*
	 * public void mostrarInfoTema() {
	 * tema.setIdTema(temaSeleccionado.getIdTema());
	 * tema.setNombre(temaSeleccionado.getNombre());
	 * tema.setDescripcion(temaSeleccionado.getDescripcion());
	 * 
	 * }
	 */

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Tema getTema() {
		return tema;
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

	// TOO LO RELACIONADO CON MULTIMEDIA
	public Multimedia getMultimedia() {
		return multimedia;
	}

	public void setMultimedia(Multimedia multimedia) {
		this.multimedia = multimedia;
	}

	// TODO LO RELACIONADO CON PDF
	public UploadedFile getPdf() {
		return pdf;
	}

	public void setPdf(UploadedFile pdf) {
		this.pdf = pdf;
	}

}
