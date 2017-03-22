package co.edu.uniquindio.moodlesoft.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity(name="tema")
@Table(name="tema")
public class Tema implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributos de la entidad tema 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTema;
	@Column(name="nombre")
	private String nombre;
	@Column(name="descripcion")
	private String descripcion;
	@OneToMany(fetch=FetchType.LAZY,mappedBy="tema")
	private List<Cuestionario> cuestionarios;
	/**
	 * @return the idTema
	 */
	public int getIdTema() {
		return idTema;
	}
	/**
	 * @param idTema the idTema to set
	 */
	public void setIdTema(int idTema) {
		this.idTema = idTema;
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
