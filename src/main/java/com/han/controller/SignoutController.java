package com.han.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.han.dao.UserDao;

@WebServlet("/signout")
public class SignoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignoutController() {
        super();
        this.userDao = new UserDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		if (session.getAttribute("sessionId") == null) {
			response.sendRedirect("main");
		} else {
			
			String user_id = session.getAttribute("sessionId").toString();
			userDao.deleteUser(Integer.parseInt(user_id));
			
			session.removeAttribute("sessionId");
			session.removeAttribute("sessionName");
			response.sendRedirect("main");
			
		}
		
		
		
	}

}
