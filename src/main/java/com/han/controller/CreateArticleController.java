package com.han.controller;

import java.awt.print.Printable;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.View;

import com.han.dao.ArticleDao;
import com.han.dao.LectureDao;
import com.han.model.Article;
import com.han.model.Lecture;

@WebServlet("/createarticle")
public class CreateArticleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticleDao articleDao;   

    public CreateArticleController() {
        super();
        this.articleDao = new ArticleDao();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String id = null;
		
		if (session.getAttribute("sessionId") != null) {
			
			RequestDispatcher view = request.getRequestDispatcher("/articleCreate.jsp");
	        view.forward(request, response);
	        response.sendRedirect("articlelist");
	        
		} else {
			
			response.sendRedirect("login");
			
			
		}
		
		
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession();
		String id = session.getAttribute("sessionId").toString();
		

		
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		
		Article article = new Article(Integer.parseInt(id), title, body);
		System.out.println(article);
		articleDao.addArticle(article);
		 response.sendRedirect("articlelist");

		
		
	}

}
