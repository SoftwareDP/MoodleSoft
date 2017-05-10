package co.edu.uniquindio.moodlesoft.bean;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "multimediaBean")
@ViewScoped
public class MultimediaBean {

	private UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}
	
	public void upload() {
		
		
		Path folder = Paths.get("C:\\Users\\Public\\");
		String filename = FilenameUtils.getBaseName(file.getFileName()); 
		String extension = FilenameUtils.getExtension(file.getFileName());
	
		
		try {
			Path files=Files.createTempFile(folder,filename+"-","."+extension);
			InputStream input = file.getInputstream();
		    Files.copy(input, files, StandardCopyOption.REPLACE_EXISTING);
			//Files.copy(input, files, StandardCopyOption.COPY_ATTRIBUTES);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Uploaded file successfully saved in " + file);
    }
	
}
