package com.han.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.han.dao.ArticleDao;
import com.han.dao.LectureDao;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LectureDao lectureDao;
	ArticleDao articleDao;

    public AdminController() {
        super();
        lectureDao = new LectureDao();
        articleDao = new ArticleDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		String page= request.getParameter("page");
		
		
		if (page.equalsIgnoreCase("lecture")) {
			
			
			try {

				request.setAttribute("lectures", lectureDao.getAllLectures());
				RequestDispatcher view = request.getRequestDispatcher("/adminLecture.jsp");
			    view.forward(request, response);
			} catch (Exception e) {
				response.sendRedirect("adminlogin");
			}
			
			
		} else if (page.equalsIgnoreCase("article")) {
			
			try {
		
				request.setAttribute("articles", articleDao.getAllArticles());
		        RequestDispatcher view = request.getRequestDispatcher("/adminArticle.jsp");
		        view.forward(request, response);
		        
			} catch (Exception e) {
				response.sendRedirect("adminlogin");
			}
			
		} else if (page.equalsIgnoreCase("main")) {
			
			RequestDispatcher view = request.getRequestDispatcher("/admin.jsp");
		    view.forward(request, response);
			
		}
		
	
	
	
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		
	}

}
