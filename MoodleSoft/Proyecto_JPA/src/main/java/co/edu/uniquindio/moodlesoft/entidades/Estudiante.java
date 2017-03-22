package co.edu.uniquindio.moodlesoft.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity(name="estudiante")
@Table(name="estudiante")
public class Estudiante extends Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9217536805761084593L;
	
	@OneToMany
	@JoinTable(name = "estudiante_x_cuestionario", joinColumns = @JoinColumn(name = "idEstudiante"), inverseJoinColumns = @JoinColumn(name = "idCuestionario"))
	private List<Cuestionario> cuestionarios;

}
