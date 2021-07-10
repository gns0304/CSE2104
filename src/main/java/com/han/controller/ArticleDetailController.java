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

@WebServlet("/articledetail")
public class ArticleDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticleDao articleDao;   

    public ArticleDetailController() {
        super();
        this.articleDao = new ArticleDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		
		if (session.getAttribute("sessionId") != null) {
			
			request.setAttribute("article", articleDao.getArticle(Integer.parseInt(id)));	
			RequestDispatcher view = request.getRequestDispatcher("/articleDetail.jsp");
	        view.forward(request, response);
	        
		} else {
			
			response.sendRedirect("login");
			
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
