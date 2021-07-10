package com.han.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.han.dao.LectureDao;
import com.han.model.Lecture;
import com.han.model.User;

@WebServlet("/createlecture")
public class CreateLectureController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    LectureDao lectureDao;
    
    public CreateLectureController() {
        super();
        lectureDao = new LectureDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		try {
			String isAdmin = session.getAttribute("isAdmin").toString();
			RequestDispatcher view = request.getRequestDispatcher("/lectureCreate.jsp");
		    view.forward(request, response);
		    response.sendRedirect("admin?page=lecture");
				} catch (Exception e) {
			response.sendRedirect("adminlogin");
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String title = request.getParameter("title");
		String language = request.getParameter("language");
		String image_url = request.getParameter("image_url");
		int price = Integer.parseInt(request.getParameter("price"));
		String description = request.getParameter("description");
		
		Lecture lecture = new Lecture(title, language, price, image_url, description);
		lectureDao.addLecture(lecture);
		
	}

}
