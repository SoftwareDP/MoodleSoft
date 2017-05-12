package co.edu.uniquindio.moodlesoft.entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity(name="estudiante_x_cuestionario")
@IdClass(Estudiante_x_CuestionarioPK.class)
@Table(name="estudiante_x_cuestionario")
public class Estudiante_x_Cuestionario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
	@JoinColumn(name = "idEstudiante")
	private Estudiante idEstudiante;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "idCuestionario")
	private Cuestionario idCuestionario;
	
	@Column(name="porcentaje")
	private double porcentaje;

	/**
	 * @return the idEstudiante
	 */
	public Estudiante getIdEstudiante() {
		return idEstudiante;
	}

	/**
	 * @param idEstudiante the idEstudiante to set
	 */
	public void setIdEstudiante(Estudiante idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	/**
	 * @return the idCuestionario
	 */
	public Cuestionario getIdCuestionario() {
		return idCuestionario;
	}

	/**
	 * @param idCuestionario the idCuestionario to set
	 */
	public void setIdCuestionario(Cuestionario idCuestionario) {
		this.idCuestionario = idCuestionario;
	}

	/**
	 * @return the porcentaje
	 */
	public double getPorcentaje() {
		return porcentaje;
	}

	/**
	 * @param porcentaje the porcentaje to set
	 */
	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	
	

}
