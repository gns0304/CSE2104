package com.han.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.han.dao.LectureDao;


@WebServlet("/lecturelist")
public class LectureListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
//	private static String MAIN = "/main.jsp";
//    private static String NEW_LECTURE = "/lectureList.jsp";
    
    LectureDao lectureDao;
    
       
    public LectureListController() {
        super();
        this.lectureDao = new LectureDao();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		request.setAttribute("lectures", lectureDao.getAllLectures());
        RequestDispatcher view = request.getRequestDispatcher("/lectureList.jsp");
        view.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
