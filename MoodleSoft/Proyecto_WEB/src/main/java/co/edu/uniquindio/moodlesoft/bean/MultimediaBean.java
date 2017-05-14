package co.edu.uniquindio.moodlesoft.bean;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.model.UploadedFile;

import co.edu.uniquindio.moodlesoft.ejbs.MultimediaEJB;
import co.edu.uniquindio.moodlesoft.entidades.Multimedia;
import co.edu.uniquindio.moodlesoft.entidades.Tema;

@ManagedBean(name = "multimediaBean")
@ViewScoped
public class MultimediaBean {

	private UploadedFile file;
	
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
	
	@PostConstruct
	public void init() {
		listMultimediaPDF= new ArrayList<>();
		listMultimediaVideos= new ArrayList<>();
		listMultimediaYutube=new ArrayList<>();
	}
	
	public void cargarTablas(){
		cargarPDF();
		cargarVideo();
		cargarYotube();
	}
	
	public void cargarPDF(){
		Tema x =(Tema) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("tema");
		listMultimediaPDF=multimediaEJB.getListaMultiediaPDF(x.getIdTema());
	}
	
	public void cargarYotube(){
		Tema x =(Tema) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("tema");
		listMultimediaYutube=multimediaEJB.getListaMultiediaYoutube(x.getIdTema());
	}
	public void cargarVideo(){
		Tema x =(Tema) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("tema");
		listMultimediaVideos=multimediaEJB.getListaMultiediaVideo(x.getIdTema());
	}
	
	public void upload() {
		
		if(tipo!=null||!tipo.isEmpty()){
		Multimedia multimedia=new Multimedia();
		Path folder = Paths.get("/home/juan-david/Documentos/");
		String filename = FilenameUtils.getBaseName(file.getFileName()); 
		String extension =FilenameUtils.getExtension(file.getFileName());
		String x= filename+"."+extension;
		try{
			Path files=Files.createTempFile(folder,filename,"."+extension);
			InputStream input = file.getInputstream();
		    Files.copy(input, files, StandardCopyOption.REPLACE_EXISTING);
		    multimedia.setDireccion(folder+x);
		    multimedia.setNombre(x);
		    multimedia.setTipo(tipo);
		    multimedia.setTema((Tema)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("tema"));
		    multimediaEJB.crear(multimedia);
		    FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Uploaded file successfully saved in " + file);
		}
		
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
	
	
	
}