package ro.forum.servlets;

import java.io.IOException;

import javax.persistence.NoResultException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ro.forum.beans.UsersBEan;
import ro.forum.entities.*;
import javax.servlet.RequestDispatcher; 


/**
 * Servlet implementation class AddContServlet
 */
@WebServlet("/AddContServlet")
public class AddContServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String message = "";
		String username=request.getParameter("username");
		String parola=request.getParameter("parola");
		String nume=request.getParameter("nume");
		String prenume=request.getParameter("prenume");
		String email=request.getParameter("email");
		
		if (	nume.equals("") || nume.equals(null) ||
				prenume.equals("") || prenume.equals(null) ||
				email.equals("") || email.equals(null) ||
				username.equals("") || username.equals(null) ||
				parola.equals("") || parola.equals(null) )
			{
				request.setAttribute("mesaj_login", "Campuri necompletate!");
				getServletContext().getRequestDispatcher("/ContForum.jsp").forward(request, response);
				return;
			}
		else
		{
			
			User user = new User();
			user.setNume(nume);
			user.setEmail(email);
			user.setPasswd(parola);
			user.setPrenume(prenume);
			user.setUsername(username);
			
			UsersBEan jbuser = new UsersBEan();
			try{
				jbuser.SaveUSer(user);
				message="Cont adaugat cu succes!";
			}
			catch(final NoResultException nre)
			{
				message = "Esec adaugare cont!";
			}
			request.setAttribute("mesaj_login", message);  
			RequestDispatcher rd = request.getRequestDispatcher("/ContForum.jsp");  
			rd.forward(request, response);
			
		}
	}

}
