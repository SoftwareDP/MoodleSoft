package co.edu.uniquindio.moodlesoft.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
@Entity(name="profesor")
@Table(name="profesor")
public class Profesor extends Usuario implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
