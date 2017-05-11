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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.model.UploadedFile;

import co.edu.uniquindio.moodlesoft.entidades.Multimedia;

@ManagedBean(name = "multimediaBean")
@ViewScoped
public class MultimediaBean {

	private UploadedFile file;
	
	private List<Multimedia> listMultimediaPDF;
	private List<Multimedia> listMultimediaVideos;
	private List<Multimedia> listMultimediaYutube;
	
	private String tipo;

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
	
	
	public void caragarPDF(){
		
	}
	
	public void upload() {
		
		
		Path folder = Paths.get("C:\\Users\\Public");
		String filename = FilenameUtils.getBaseName(file.getFileName()); 
		String []extension = file.getFileName().split("\\.");
		try {
			Path files=Files.createTempFile(folder,filename,"."+extension[1]);
			InputStream input = file.getInputstream();
		    Files.copy(input, files, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Uploaded file successfully saved in " + file);
		
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
