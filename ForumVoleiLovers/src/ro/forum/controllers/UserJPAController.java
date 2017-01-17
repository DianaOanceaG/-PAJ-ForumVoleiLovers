package ro.forum.controllers;

import ro.forum.entities.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.omg.PortableInterceptor.USER_EXCEPTION;

public class UserJPAController implements Serializable {
   
   private EntityManagerFactory emf = null;
	
   public UserJPAController(EntityManagerFactory emf){
	   this.emf=emf;
   }
   
   public EntityManager getEntityManager()
   {
	   return emf.createEntityManager();
   }
   
	public void create (User user)
	{
		EntityManager em = null;
		try{
			em=getEntityManager();
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		}
		finally{
			if(em!=null)
				em.close();
		}
	}
	
	public User FindUser(Integer id)
	{
		EntityManager em = getEntityManager();
		try{
			return em.find(User.class, id);		
		}
		finally{
			em.close();
		}
		
	}
	
	public User findUserByNameAndPass(String uname, String parola)
	{
		EntityManager em = getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> from = criteria.from(User.class);
		criteria.select(from);
		criteria.where(builder.equal(from.get("username"),uname));
		TypedQuery<User> typed = em.createQuery(criteria);
		try {
			User test = typed.getSingleResult();
			String pass = test.getPasswd();
			if(pass.equals(parola))
			return typed.getSingleResult();
			else
				return null;
		}
		catch(final NoResultException nre)
		{
			return null;
		}		
	}
	
	public User findUserByName(String nume)
	{
		EntityManager em = getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> from = criteria.from(User.class);
		criteria.select(from);
		criteria.where(builder.equal(from.get("username"),nume));
		TypedQuery<User> typed = em.createQuery(criteria);
		try {
			return typed.getSingleResult();
		}
		catch(final NoResultException nre)
		{
			return null;
		}	
	}
}
