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
import com.han.model.Lecture;

@WebServlet("/mylecture")
public class MyLectureController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LectureDao lectureDao;
	
    public MyLectureController() {
        super();
        lectureDao = new LectureDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String user_id = session.getAttribute("sessionId").toString();
		String id = request.getParameter("id");
		
		
		List<Lecture> lectures = lectureDao.getPersonalLectures(Integer.parseInt(user_id));
		
		for (int i = 0; i < lectures.size(); i++) {
			if(lectures.get(i).getLecture_id() == Integer.parseInt(id)) {
				Lecture lecture = lectures.get(i);
				request.setAttribute("lecture", lecture);
			    RequestDispatcher view = request.getRequestDispatcher("/myLecture.jsp");
			    view.forward(request, response);
				
			}
		}
		
		response.sendRedirect("lecturelist");
	
		
	}
}