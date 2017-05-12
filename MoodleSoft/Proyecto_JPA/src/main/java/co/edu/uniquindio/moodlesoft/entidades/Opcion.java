package co.edu.uniquindio.moodlesoft.entidades;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name="opcion")
@Table(name="opcion")
public class Opcion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOpcion;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="correcta")
	private boolean correcta;
	@ManyToOne
	@JoinColumn(name = "idPregunta", nullable = false)
	private Pregunta pregunta;
	/**
	 * @return the idOpcion
	 */
	public int getIdOpcion() {
		return idOpcion;
	}
	/**
	 * @param idOpcion the idOpcion to set
	 */
	public void setIdOpcion(int idOpcion) {
		this.idOpcion = idOpcion;
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
	/**
	 * @return the correcta
	 */
	public boolean isCorrecta() {
		return correcta;
	}
	/**
	 * @param correcta the correcta to set
	 */
	public void setCorrecta(boolean correcta) {
		this.correcta = correcta;
	}
}
