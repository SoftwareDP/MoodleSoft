package co.edu.uniquindio.moodlesoft.ejbs;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;


@Stateless
@LocalBean
public class TemaEJB {

	@PersistenceContext(unitName = "persistencia")
	protected transient EntityManager em;
	
	
	
	
	
	
	
}
