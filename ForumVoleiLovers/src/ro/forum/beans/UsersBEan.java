package ro.forum.beans;

import ro.forum.controllers.UserJPAController;
import ro.forum.entities.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UsersBEan {
	private EntityManagerFactory emf;
	private UserJPAController UserControl;
	public UsersBEan ()
	{
		emf =Persistence.createEntityManagerFactory("ForumVoleiLovers");
		UserControl = new UserJPAController(emf);
	}

	public void SaveUSer(User user)
	{
		UserControl.create(user);
	}
	
	public User SearchUser(String uname, String parola)
	{
		return UserControl.findUserByNameAndPass(uname, parola);
	}
	public User SearchUserByname(String name)
	{
		return UserControl.findUserByName(name);
	}
}
