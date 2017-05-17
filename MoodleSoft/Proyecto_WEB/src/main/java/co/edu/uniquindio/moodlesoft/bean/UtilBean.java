package co.edu.uniquindio.moodlesoft.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "util")
@ViewScoped
public class UtilBean implements Serializable {

	public void error(String title, String detail) {
		FacesContext faceContext = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, title, detail);
		faceContext.addMessage(null, facesMessage);
	}

	public void info(String title, String detail) {
		FacesContext faceContext = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, title, detail);
		faceContext.addMessage(null, facesMessage);
	}

}
