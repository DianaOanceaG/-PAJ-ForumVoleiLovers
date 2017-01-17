package ro.forum.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import ro.forum.beans.SubiecteBean;
import ro.forum.beans.UsersBEan;
import ro.forum.entities.*;

import javax.persistence.NoResultException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class LoginForumServlet
 */
@WebServlet("/LoginForumServlet")
public class LoginForumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config = null;//
	private ServletContext contextu = null;//
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginForumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		 config = getServletConfig();
	        if(config!=null)
	        	contextu = config.getServletContext();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String username=request.getParameter("username");
		String parola=request.getParameter("passwd");
		System.out.println(username);
		if (username.equals("") && parola.equals(""))
		{
			request.setAttribute("mesaj_login", "Campuri necompletate!!!");
			request.getRequestDispatcher("/LoginForum.jsp").forward(request, response);
			//response.sendRedirect("LoginForum.jsp");
			return;
		}else
		{	
			//tabel cu subiecte
			String tabel = "<h2>Subiecte:</h2><table border=1 cellspacing=0><tr align=center><td><b>Data</td><td><b>Denumire</td><td><b>User</td></tr>";
			
			SubiecteBean subb= new SubiecteBean();
			List<Subiecte> listSub = subb.GetListSubiecte();
			for (Subiecte sub : listSub)
			{
				String data = sub.getData().toString();
				String usern = sub.getUser().getUsername();
				tabel = tabel + "<tr><td align=center>" + data + "</td><td>" + sub.getDenumire() + "</td><td>"+ usern +"</td></tr>";
			}
			
			UsersBEan jbuser = new UsersBEan();
			User test = new User();
			test = jbuser.SearchUser(username, parola);
			try{
				
				if(test == null)
					{	
						request.setAttribute("mesaj_login", "Utilizator inexistent!");
						request.getRequestDispatcher("/LoginForum.jsp").forward(request, response);
						
						//response.sendRedirect("LoginForum.jsp");
					}
				else
				{
					request.setAttribute("recordset", tabel + "</table>");
					request.getRequestDispatcher("/Forum.jsp").forward(request, response);
					
					//response.sendRedirect("Forum.jsp");
				}
			   }
			catch(final NoResultException nre)
			{
				response.sendRedirect("LoginForum.jsp");
			
			}
		}
		
		
	}

}
