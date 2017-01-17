package ro.forum.beans;

import javax.enterprise.context.ApplicationScoped;
import ro.forum.controllers.SubiecteJPAController;
import ro.forum.controllers.UserJPAController;
import ro.forum.entities.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@ApplicationScoped
public class SubiecteBean {

	private EntityManagerFactory emf;
	private SubiecteJPAController SubiecteControl;
	
	public SubiecteBean() {
		// TODO Auto-generated constructor stub
		emf =Persistence.createEntityManagerFactory("ForumVoleiLovers");
		SubiecteControl = new SubiecteJPAController(emf);
	}

	public void SaveSubiect(Subiecte sub)
	{
		SubiecteControl.create(sub);
	}
	
	public List<Subiecte> GetListSubiecte()
	{
		return SubiecteControl.findSubiecteEntities();
	}
}
