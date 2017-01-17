package ro.forum.controllers;

import ro.forum.entities.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.omg.PortableInterceptor.USER_EXCEPTION;

public class SubiecteJPAController implements Serializable{
	
	private EntityManagerFactory emf = null;
	
	public SubiecteJPAController(EntityManagerFactory emf){
		   this.emf=emf;
	   }
	
    public EntityManager getEntityManager()
	   {
		   return emf.createEntityManager();
	   }
	   
	public void create (Subiecte subiect)
		{
			EntityManager em = null;
			try{
				em=getEntityManager();
				em.getTransaction().begin();
				em.persist(subiect);
				em.getTransaction().commit();
			}
			finally{
				if(em!=null)
					em.close();
			}
		}

	public Subiecte FindSubiecte(Integer id)
	{
		EntityManager em = getEntityManager();
		try{
			return em.find(Subiecte.class, id);		
		}
		finally{
			em.close();
		}
		
	}
	
	public List<Subiecte> findSubiecteEntities()
	{	
		return findSubiecteEntities(true, -1, -1);
	}
	
	public List<Subiecte> findSubiecteEntities(int maxResults, int firstResult)
	{
		
		return findSubiecteEntities(false, maxResults, firstResult);
	}
	
	public List<Subiecte> findSubiecteEntities(boolean all, int maxResults, int firstResult)
	{
		EntityManager em = getEntityManager();
		try{
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(Subiecte.class));
			Query q = em.createQuery(cq);
			if(!all)
			{
				q.setMaxResults(maxResults);
				q.setFirstResult(firstResult);
			}
			return q.getResultList();
		}
		finally{
			em.close();
		}
		
	}
	
}
