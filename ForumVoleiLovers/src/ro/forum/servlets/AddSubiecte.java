package ro.forum.servlets;

import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ro.forum.beans.UsersBEan;
import ro.forum.beans.SubiecteBean;
import ro.forum.entities.*;

import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher; 


/**
 * Servlet implementation class AddSubiecte
 */
@WebServlet("/AddSubiecte")
public class AddSubiecte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config = null;//
	private ServletContext contextu = null;//
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSubiecte() {
        super();
        // TODO Auto-generated constructor stub
    }
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		 config = getServletConfig();
	        if(config!=null)
	        	contextu = config.getServletContext();
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String message = "";
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date data = new Date();
		System.out.println(data.toString());
		UsersBEan jpabean = new UsersBEan();
	    String name = request.getUserPrincipal().getName();
	    System.out.println("nume user " + name);
	    User founduser = jpabean.SearchUserByname(name);
		System.out.println(founduser.getNume() + "GAsit ce trebuia");
		//System.out.println(dateFormat.format(date));
		String denumire = request.getParameter("denumiresub");
		if(denumire.equals("") || (denumire.equals(null)))
		{
			System.err.println("A intrat aici la lala ");
			request.setAttribute("mesaj_add", "Campuri necompletate!");
			request.getRequestDispatcher("/Forum.jsp").forward(request, response);
			//RequestDispatcher rdd = request.getRequestDispatcher("/Forum.jsp"); 
			//rdd.forward(request, response);
			//response.sendRedirect("Forum.jsp");
			return;
		}
		else
		{
			Subiecte subiect = new Subiecte();
			subiect.setDenumire(denumire);
			subiect.setData(data);
			subiect.setUser(founduser);
			SubiecteBean subbean = new SubiecteBean();
			try{
				subbean.SaveSubiect(subiect);
				message= "Adaugat cu succes!";
			}
			catch(final NoResultException nre){
				message = "Esec adaugare subiect!";
			}
			request.setAttribute("mesaj_login", message);  
			request.getRequestDispatcher("/Forum.jsp").forward(request, response);
			//RequestDispatcher rd = request.getRequestDispatcher("/Forum.jsp");  
			//rd.forward(request, response);
		}
	}

}
