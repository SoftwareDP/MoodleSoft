package co.edu.uniquindio.moodlesoft.ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniquindio.moodlesoft.entidades.Tema;

@Stateless
@LocalBean
public class TemaEJB {

	@PersistenceContext(unitName = "persistencia")
	protected transient EntityManager em;

	/**
	 * Metodo que permite la persistencia de un Tema en la base de datos
	 * 
	 * @param pTema
	 *            El tema a persistir
	 */
	public boolean crearTema(Tema pTema) {
		Tema tema = buscarTema(pTema.getNombre());
		if (tema != null) {
			em.persist(pTema);
			return true;
		}
		return false;
	}

	/**
	 * Eliminar tema con datos que esten en el tema
	 */
	public boolean eliminarTema(Tema tema) {
		if (em.find(null, tema.getIdTema()) != null) {
			em.remove(tema);
			return true;
		} else {
			return false;
		}

	}
	
	public boolean editarTema(Tema tema){
		if(buscarTema(tema.getNombre())==null){
			em.merge(tema);
			return true;
		}
		return false;
	}

	/**
	 * Metodo para buscar tema por nombre
	 * 
	 * @param nombre
	 *            Nombre del tema a buscar
	 * @return El tema correspondiente al parametro de buscaqueda
	 */
	public Tema buscarTema(String nombre) {
		Query query = em.createNamedQuery(Tema.BUSCARPORNOMBRE);
		query.setParameter(1, nombre);
		List<Tema> res = query.getResultList();
		return res.size() == 0 ? null : res.get(0);
	}

}
