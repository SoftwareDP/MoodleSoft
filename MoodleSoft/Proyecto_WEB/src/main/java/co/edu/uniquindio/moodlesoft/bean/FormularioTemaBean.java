package co.edu.uniquindio.moodlesoft.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
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

	@EJB
	private TemaEJB temaEJB;

	@EJB
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
	
	public void imprimir(){
		System.out.println(temaSeleccionado.getIdTema());
	}

	/**
	 * Metodo que permite modificar el contenido del tema creado
	 */
	public String modificarTema() {
		temaEJB.editarTema(temaSeleccionado);
		return "CrearTema";
	}
	
	public String  eliminartema(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("tema");
		temaEJB.eliminarTema(temaSeleccionado);
		return "CrearTema";
	}

	/**
	 * Metodo que permite inicializar los atributos
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



	public String  mostrarVideo(){
		return multimediaEJB.buscarMultimedia(multimedia.getNombre());
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
	
	public String cargarTemaEditar(){
		temaSeleccionado=(Tema) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("tema");
		return temaSeleccionado.getNombre();
	}
	
	
	public String editarTema(){
		String red="";
		if(temaSeleccionado!=null){
			//System.out.println("entra");
			red="EditarTema.jsf";
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("tema", temaSeleccionado);
		}else{
			red="CrearTema.jsf";
		}
		return red;
	}
	

}