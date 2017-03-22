package co.edu.uniquindio.moodlesoft.entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity(name="multimedia")
@Table(name="multimedia")
public class Multimedia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMultimedia;
	@Column(name="nombre")
	private String nombre;
	@Column(name="direccion")
	private String direccion;
	@ManyToOne
	@JoinColumn(name = "idTema", nullable=false)
	private Tema tema;
	/**
	 * @return the idMultimedia
	 */
	public int getIdMultimedia() {
		return idMultimedia;
	}
	/**
	 * @param idMultimedia the idMultimedia to set
	 */
	public void setIdMultimedia(int idMultimedia) {
		this.idMultimedia = idMultimedia;
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
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
