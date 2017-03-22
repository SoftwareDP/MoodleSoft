package co.edu.uniquindio.moodlesoft.entidades;

import java.io.Serializable;

public class Estudiante_x_CuestionarioPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idEstudiante;
	private int idCuestionario;
	/**
	 * @return the idEstudiante
	 */
	public int getIdEstudiante() {
		return idEstudiante;
	}
	/**
	 * @param idEstudiante the idEstudiante to set
	 */
	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
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
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCuestionario;
		result = prime * result + idEstudiante;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudiante_x_CuestionarioPK other = (Estudiante_x_CuestionarioPK) obj;
		if (idCuestionario != other.idCuestionario)
			return false;
		if (idEstudiante != other.idEstudiante)
			return false;
		return true;
	}
}