package com.han.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.han.dao.LectureDao;
import com.han.dao.UserDao;
import com.han.model.Lecture;
import com.han.model.User;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;


@WebServlet("/main")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao;
	LectureDao lectureDao;
       
    public IndexController() {
        super(); 
        this.userDao = new UserDao();
        this.lectureDao = new LectureDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		HttpSession session = request.getSession();
		request.setAttribute("sessionName", session.getAttribute("sessionName"));
	
		String id = null;
		
		if (session.getAttribute("sessionId") != null) {
			id = session.getAttribute("sessionId").toString();
		}
		
		if (id != null) {
			
			List<Lecture> lectures = lectureDao.getPersonalLectures(Integer.parseInt(id));
			request.setAttribute("lectures", lectures);
			
		}
		
		
        

		
		RequestDispatcher view = request.getRequestDispatcher("/main.jsp");
        view.forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}
	

}
