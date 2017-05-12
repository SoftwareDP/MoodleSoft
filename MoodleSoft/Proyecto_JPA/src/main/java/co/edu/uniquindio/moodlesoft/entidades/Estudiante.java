package co.edu.uniquindio.moodlesoft.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity(name="estudiante")
@Table(name="estudiante")
@NamedQueries({@NamedQuery(name= Estudiante.LOGINESTUDIANTE, query="select e from estudiante e where e.correo=?1 and e.contrasena=?2"),
@NamedQuery(name=Estudiante.LISTAESTUDIANTES,query="select es from estudiante es")})
public class Estudiante extends Usuario implements Serializable {
	
	@OneToMany
	@JoinTable(name = "estudiante_x_cuestionario", joinColumns = @JoinColumn(name = "idEstudiante"), inverseJoinColumns = @JoinColumn(name = "idCuestionario"))
	private List<Cuestionario> cuestionarios;
	public static final String LOGINESTUDIANTE="estudiante.login";
	public static final String LISTAESTUDIANTES="estudiante.listarEstudiante";

}
