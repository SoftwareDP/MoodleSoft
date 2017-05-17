package co.edu.uniquindio.moodlesoft.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.primefaces.model.UploadedFile;
import co.edu.uniquindio.moodlesoft.ejbs.MultimediaEJB;
import co.edu.uniquindio.moodlesoft.entidades.Multimedia;
import co.edu.uniquindio.moodlesoft.entidades.Tema;

@ManagedBean(name = "multimediaBean")
@ViewScoped
public class MultimediaBean {

	private UploadedFile file;
	private String youtube;
	private String nombre;
	private String enlace;
	private Multimedia verPDF = new Multimedia();
	private Multimedia verVideo;
	private Multimedia verVideoYoutube;
	private List<Multimedia> listMultimediaPDF;
	private List<Multimedia> listMultimediaVideos;
	private List<Multimedia> listMultimediaYutube;

	private String tipo;

	@EJB
	private MultimediaEJB multimediaEJB;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void cargarEnPDF() {

		char msj[] = verVideoYoutube.getDireccion().toCharArray();
		for (int i = 0; i < msj.length; i++) {
			if (msj[i] == '=') {
				enlace = verVideoYoutube.getDireccion().substring(i + 1, msj.length);
				System.out.println(enlace);
				break;
			}
		}
	}
	
	public void cargarVerPDF(){
		System.out.println(verPDF.getNombre());
	}
	public void cargarVerVideo(){
		System.out.println(verVideo.getNombre());
	}

	@PostConstruct
	public void init() {
		listMultimediaPDF = new ArrayList<>();
		listMultimediaVideos = new ArrayList<>();
		listMultimediaYutube = new ArrayList<>();
		verPDF = new Multimedia();
		verVideo = new Multimedia();
		verVideoYoutube = new Multimedia();
		enlace = "";
		cargarTablas();
	}

	public void limpiarUpload(){
		enlace="";
		nombre="";
		youtube="";
	}
	public void cargarTablas() {
		cargarPDF();
		cargarVideo();
		cargarYotube();
	}

	public String imprimir() {
		System.out.println("hola nombre" + verPDF.getIdMultimedia());
		System.out.println("videoyoutube" + verVideoYoutube.getIdMultimedia());
		System.out.println("video" + verVideo.getIdMultimedia());
		return "ekqX2zuGGIs";
	}

	public void cargarPDF() {
		Tema x = (Tema) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("tema");
		listMultimediaPDF = multimediaEJB.getListaMultiediaPDF(x.getIdTema());
	}

	public void cargarYotube() {
		Tema x = (Tema) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("tema");
		listMultimediaYutube = multimediaEJB.getListaMultiediaYoutube(x.getIdTema());
	}

	public void cargarVideo() {
		Tema x = (Tema) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("tema");
		listMultimediaVideos = multimediaEJB.getListaMultiediaVideo(x.getIdTema());
	}

	public void upload() {
		String ruta = "/home/juan-david/Documentos/desarrolloSoftware/MoodleSoft/MoodleSoft/Proyecto_WEB/src/main/webapp/resources/multimedia/";
		Multimedia multimedia = new Multimedia();
		
		if (tipo != null || !tipo.isEmpty()) {
			if (tipo.equals("PDF") || tipo.equals("video")) {
				String filename = FilenameUtils.getBaseName(file.getFileName());
				String extension = FilenameUtils.getExtension(file.getFileName());
				String x = filename + "." + extension;
				try {
					InputStream input = file.getInputstream();
					OutputStream output = new FileOutputStream(new File(ruta, x));

					try {
						IOUtils.copy(input, output);
					} finally {
						IOUtils.closeQuietly(input);
						IOUtils.closeQuietly(output);
					}
					multimedia.setDireccion(ruta + x);
					multimedia.setNombre(x);
					multimedia.setTipo(tipo);
					multimedia.setTema(
					(Tema) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("tema"));
					multimediaEJB.crear(multimedia);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				multimedia.setNombre(nombre);
				multimedia.setDireccion(youtube);
				multimedia.setTipo(tipo);
				multimedia.setTema((Tema) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("tema"));
				multimediaEJB.crear(multimedia);
			}
		}
		limpiarUpload();

	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Multimedia> getListMultimedia() {
		return listMultimediaPDF;
	}

	public void setListMultimedia(List<Multimedia> listMultimedia) {
		this.listMultimediaPDF = listMultimedia;
	}

	public List<Multimedia> getListMultimediaPDF() {
		return listMultimediaPDF;
	}

	public void setListMultimediaPDF(List<Multimedia> listMultimediaPDF) {
		this.listMultimediaPDF = listMultimediaPDF;
	}

	public List<Multimedia> getListMultimediaVideos() {
		return listMultimediaVideos;
	}

	public void setListMultimediaVideos(List<Multimedia> listMultimediaVideos) {
		this.listMultimediaVideos = listMultimediaVideos;
	}

	public List<Multimedia> getListMultimediaYutube() {
		return listMultimediaYutube;
	}

	public void setListMultimediaYutube(List<Multimedia> listMultimediaYutube) {
		this.listMultimediaYutube = listMultimediaYutube;
	}

	public String getYoutube() {
		return youtube;
	}

	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}

	public Multimedia getVerPDF() {
		return verPDF;
	}

	public void setVerPDF(Multimedia verPDF) {
		this.verPDF = verPDF;
	}

	public Multimedia getVerVideo() {
		return verVideo;
	}

	public void setVerVideo(Multimedia verVideo) {
		this.verVideo = verVideo;
	}

	public Multimedia getVerVideoYoutube() {
		return verVideoYoutube;
	}

	public void setVerVideoYoutube(Multimedia verVideoYoutube) {
		this.verVideoYoutube = verVideoYoutube;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEnlace() {
		return enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

}