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
import com.han.model.User;

@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao;   

    public AdminLogin() {
        super();
        this.userDao = new UserDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("sessionId") == null) {
		RequestDispatcher view = request.getRequestDispatcher("/adminLogin.jsp");
	    view.forward(request, response);
		} else {
			response.sendRedirect("main");
		}
	
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		User user = userDao.getUser(id, password);
		HttpSession session = request.getSession();
		
		
		if (session.getAttribute("sessionId") == null) {
			
			if (user != null) {
				
				if(user.getAdmin() == true) {
					
					session.setAttribute("sessionId", user.getUser_id());
					session.setAttribute("sessionName", user.getName());
					session.setAttribute("isAdmin", true);
					response.sendRedirect("main");
					
				} else {
					
				    RequestDispatcher view = request.getRequestDispatcher("/adminLogin.jsp");
				    request.setAttribute("alert", "관리자 계정으로 로그인하여 주십시오.");
				    view.forward(request, response);
					
				}
				
				
			} else {
				
			    RequestDispatcher view = request.getRequestDispatcher("/adminLogin.jsp");
			    request.setAttribute("alert", "로그인 정보를 확인하여 주십시오.");
			    view.forward(request, response);
				
			}
			
		} else {
			
			response.sendRedirect("main");
			
		}
		
		
		
		
	}


}
