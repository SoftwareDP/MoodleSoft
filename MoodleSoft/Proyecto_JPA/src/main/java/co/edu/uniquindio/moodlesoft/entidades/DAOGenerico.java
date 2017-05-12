package co.edu.uniquindio.moodlesoft.entidades;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DAOGenerico<T> {

	private EntityManager em;

	private Class<T> clase;

	public DAOGenerico(EntityManager em) {
		super();
		this.em = em;
	}

	public DAOGenerico(EntityManager em, Class<T> clase) {
		super();
		this.em = em;
		this.clase = clase;
	}

	public void crear(T obj) {
		em.persist(obj);
	}

	
	public void editar(T obj) {
		em.merge(obj);
	}

	public void eliminar(T obj) {
		em.remove(obj);
	}

	public T buscar(Object pk) {
		return em.find(clase, pk);
	}

	public void setClase(Class<T> clase) {
		this.clase = clase;
	}

	public List ejecutarNamedQuery(String query, Object... params) {

		Query q = em.createNamedQuery(query);
		for (int i = 0; i < params.length; i++) {
			Object p = params[i];
			q.setParameter(i + 1, p);
		}
		return q.getResultList();
	}

}
