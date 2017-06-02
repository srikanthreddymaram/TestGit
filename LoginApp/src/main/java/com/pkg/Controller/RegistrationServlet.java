package com.pkg.Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pkg.userbeans.UserBeans;
import com.pkg.userdb.RegistrationDB;

/**
 * Servlet implementation class RegistrationServlet
 */

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//PrintWriter out=response.getWriter();
		String userid=request.getParameter("userid");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String mobileno=request.getParameter("mobileno");
		//Here we are set input values
		UserBeans userBeans=new UserBeans();
		userBeans.setUser_id(userid);
		userBeans.setUser_name(username);
		userBeans.setPassword(password);
		userBeans.setEmail_id(email);
		userBeans.setMobile_no(mobileno);
		
		boolean flag=RegistrationDB.registerUser(userBeans);
		
		RequestDispatcher rd=null;
		if(flag)
		{
			rd=request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
		}
		else
		{
			rd=request.getRequestDispatcher("failure.jsp");
			rd.forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
