package com.han.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.han.dao.ArticleDao;

/**
 * Servlet implementation class ArticleListController
 */
public class ArticleListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ArticleDao articleDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleListController() {
        super();
        articleDao = new ArticleDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("articles", articleDao.getAllArticles());
        RequestDispatcher view = request.getRequestDispatcher("/articleList.jsp");
        view.forward(request, response);
		
		
	}



}
