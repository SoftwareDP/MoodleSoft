package co.edu.uniquindio.moodlesoft.entidades;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name="cuestionario")
public class Cuestionario implements Serializable{

	/**
	 * Atributos de la entidad cuestionario
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCuestionario;
	@Column(name="nombre")
	private String nombre;
	@Column(name="activo")
	private boolean activo;
	@ManyToOne
	@JoinColumn(name = "idTema", nullable = false)
	private Tema tema;
	/**
	 * @return the idCuestionario
	 */
	public int getIdCuestionario() {
		return idCuestionario;
	}
	/**
	 * @param idCuestionario the idCuestionario to set
	 */
	public void setIdCuestionario(int idCuestionario) {
		this.idCuestionario = idCuestionario;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the activo
	 */
	public boolean isActivo() {
		return activo;
	}
	/**
	 * @param activo the activo to set
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	/**
	 * @return the tema
	 */
	public Tema getTema() {
		return tema;
	}
	/**
	 * @param tema the tema to set
	 */
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	
}
