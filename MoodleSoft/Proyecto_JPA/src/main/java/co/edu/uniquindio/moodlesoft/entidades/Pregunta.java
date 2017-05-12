package co.edu.uniquindio.moodlesoft.entidades;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="pregunta")
public class Pregunta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPregunta;
	@Column(name="numeroPregunta",unique=true)
	private int numerPregunta;
	@Column(name="descripcion")
	private String descripcion;
	@ManyToOne
	@JoinColumn(name = "idCuestionario", nullable = false)
	private Cuestionario cuestionario;
	/**
	 * @return the idPregunta
	 */
	public int getIdPregunta() {
		return idPregunta;
	}
	/**
	 * @param idPregunta the idPregunta to set
	 */
	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}
	/**
	 * @return the numerPregunta
	 */
	public int getNumerPregunta() {
		return numerPregunta;
	}
	/**
	 * @param numerPregunta the numerPregunta to set
	 */
	public void setNumerPregunta(int numerPregunta) {
		this.numerPregunta = numerPregunta;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
