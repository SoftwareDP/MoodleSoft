package co.edu.uniquindio.moodlesoft.ejbs;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.uniquindio.moodlesoft.entidades.DAOGenerico;


@Stateless
@LocalBean
public abstract class EJBGenerico<T> {

	@PersistenceContext(unitName = "persistencia")
	protected transient EntityManager em;
	
	protected DAOGenerico<T> dao;
	
   //@PostConstruct
	public void init(){
		dao=new DAOGenerico<T>(em);
	}
	

	public void crear(T obj){
		dao.crear(obj);
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public T buscar(Object pk){
		return dao.buscar(pk);
	}
	
	public abstract void setClase(Class<T> clase); 
}
