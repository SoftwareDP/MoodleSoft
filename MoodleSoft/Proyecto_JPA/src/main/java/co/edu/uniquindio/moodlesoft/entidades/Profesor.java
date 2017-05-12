package co.edu.uniquindio.moodlesoft.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity(name="profesor")
@Table(name="profesor")
@NamedQueries(@NamedQuery(name= Profesor.LOGINPROFESOR, query="select p from profesor p where p.correo=?1 and p.contrasena=?2"))
public class Profesor extends Usuario implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String LOGINPROFESOR="profesor.login";

}
