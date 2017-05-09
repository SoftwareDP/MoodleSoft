package co.edu.uniquindio.moodlesoft.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
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
		
		try{
			if(file!=null){
		String fileName="C:\\Bibliotecas\\Documentos\\"+file.getFileName();
		System.out.println(file.getFileName());
		File filep= new File(fileName);
		FileOutputStream fileOutputStream= new FileOutputStream(filep);
		byte[] bufer=new byte[8192];  
		InputStream inputStream=file.getInputstream();
		
		int bulk;
		while(true){
			bulk=inputStream.read(bufer);
			if(bulk < 0){
				break;
			}
			System.out.println("entra");
			fileOutputStream.write(bufer,0, bulk);
			fileOutputStream.flush();
		}
	
		fileOutputStream.close();
		inputStream.close();
		
    
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
			}    
		}catch (IOException e) {
			// TODO: handle exception
		}
       
    }
	
}
