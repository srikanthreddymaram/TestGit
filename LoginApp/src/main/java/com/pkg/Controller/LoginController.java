package com.pkg.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pkg.userbeans.UserBeans;
import com.pkg.userdb.LoginDB;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context=getServletContext();
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		context.log("Here we are getting inputs from browser");
		UserBeans userBeans=new UserBeans();
		userBeans.setUser_id(userid);
		userBeans.setPassword(password);
		
		boolean flag=LoginDB.authantication(userBeans);
		String username=userBeans.getUser_name();
		RequestDispatcher rd=null;
		if(flag)
		{
			HttpSession session=request.getSession();
			session.setAttribute("username", username);
			/*rd=request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);*/
			response.sendRedirect("welcome.jsp");
		}
		else
		{
			rd=request.getRequestDispatcher("loginfail.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
