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

@WebServlet("/editinfo")
public class EditInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao;
 
    public EditInfoController() {
        super();
        this.userDao = new UserDao();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		try {
			String action = request.getParameter("action");
			
			if(action.equalsIgnoreCase("delete")) {
				
				if (session.getAttribute("sessionId") == null) {
					response.sendRedirect("login");
				} else {
					String id = session.getAttribute("sessionId").toString();
					System.out.print(id);
					userDao.deleteUser(Integer.parseInt(id));
					session.removeAttribute("sessionId");
					session.removeAttribute("sessionName");
					session.removeAttribute("isAdmin");
					response.sendRedirect("main");
				}
				
				
			}
			
		} catch (Exception e) {
			if (session.getAttribute("sessionId") == null) {
				response.sendRedirect("login");
			} else {
				String id = session.getAttribute("sessionId").toString();
				User user = userDao.getUserByID(Integer.parseInt(id));
				request.setAttribute("user", user);
				RequestDispatcher view = request.getRequestDispatcher("/editInfo.jsp");
				view.forward(request, response);
			}
		}
		
		
	
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user_id = session.getAttribute("sessionId").toString();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		User user = new User(Integer.parseInt(user_id), id, password, name, email, false);
		userDao.editUser(user);
		
		session.setAttribute("sessionName", name);
		response.sendRedirect("main");
		
		
	}

}
