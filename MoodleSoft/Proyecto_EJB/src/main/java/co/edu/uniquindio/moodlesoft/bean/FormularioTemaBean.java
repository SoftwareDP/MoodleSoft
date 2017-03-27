package co.edu.uniquindio.moodlesoft.bean;

import javax.inject.Inject;

import co.edu.uniquindio.moodlesoft.ejbs.TemaEJB;
import co.edu.uniquindio.moodlesoft.entidades.Tema;

public class FormularioTemaBean {


	
	public Tema tema=new Tema();

	@Inject
	private TemaEJB temaEJB;

	/**
	 * Metodo que permite ingresar un registro a la base de datos, en la tabla
	 * Tema
	 */
	public void registrarTema() {
		temaEJB.crearTema(tema);
		limpiarCampos();

	}

	/**
	 * Método que permite inicializar los atributos
	 */
	public void limpiarCampos() {
		tema=new Tema();
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	
	
	

}
