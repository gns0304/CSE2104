package com.han.controller;

import java.awt.print.Printable;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.util.SystemPropertyReplacerListener;

import com.han.dao.ArticleDao;
import com.han.model.Article;



public class UpdateArticleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticleDao articleDao;   
	
	
    public UpdateArticleController() {
        super();
        this.articleDao = new ArticleDao();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		String user_id = session.getAttribute("sessionId").toString();
		String isAdmin = "false";
		try {
			isAdmin = session.getAttribute("isAdmin").toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (session.getAttribute("sessionId") != null) {
			
		
			if (action.equalsIgnoreCase("delete")) {
				
				
			
				 if(isAdmin.equalsIgnoreCase("true")){
					
					articleDao.deleteArticle(Integer.parseInt(id));
					 response.sendRedirect("admin?page=article");
				 }
				 else if(Integer.parseInt(user_id) == articleDao.getWriter(Integer.parseInt(id))) {
						
						articleDao.deleteArticle(Integer.parseInt(id));
						 response.sendRedirect("articlelist");
				}
				else {
					
					response.sendRedirect("articledetail?id=" + id);
					
				}
				
				
			}else if (action.equalsIgnoreCase("edit")) {
				

				if (session.getAttribute("sessionId") != null) {
					
					request.setAttribute("article", articleDao.getArticle(Integer.parseInt(id)));	
					RequestDispatcher view = request.getRequestDispatcher("/articleUpdate.jsp");
			        view.forward(request, response);
			        
				} else {
					
					response.sendRedirect("login");
					
					
				}
				
			}
			
			
			
	        
		} else {
			
			response.sendRedirect("login");
			
			
		}

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");


		String user_id = session.getAttribute("sessionId").toString();
		String article_id = request.getParameter("article_id");
		

		if(Integer.parseInt(user_id) == articleDao.getWriter(Integer.parseInt(article_id))) {
			System.out.print("asdf");

			String title = request.getParameter("title");
			
			String body = request.getParameter("body");
			
			Article article = new Article(Integer.parseInt(article_id), Integer.parseInt(user_id), title, body);
			System.out.print(article);
			articleDao.updateArticle(article);
			
			response.sendRedirect("articledetail?id=" + article_id);
			
			
		} else {

			response.sendRedirect("articledetail?id=" + article_id);
			
		}
		
	}

}
