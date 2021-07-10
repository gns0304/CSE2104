package com.han.controller;

import static org.junit.Assert.assertNotNull;

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

import com.han.dao.LectureDao;
import com.han.model.Lecture;

@WebServlet("/lecture")
public class LectureController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    LectureDao lectureDao;

    public LectureController() {
        super();
        lectureDao = new LectureDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		String user_id = null;
		try {
			user_id = session.getAttribute("sessionId").toString();
		} catch (Exception e) {
			response.sendRedirect("login");
			return;
		}
		
		
		List<Lecture> lectures = lectureDao.getPersonalLectures(Integer.parseInt(user_id));
		
		
	
		if(action.equalsIgnoreCase("detail")) {
			
			boolean isMyLecture = false;
			
			for (int i = 0; i < lectures.size(); i++) {
				if(lectures.get(i).getLecture_id() == Integer.parseInt(id)) {
					isMyLecture = true;
				}
			}
			
			if(isMyLecture) {
				response.sendRedirect("mylecture?id=" + id);
				return;
			}else {
				Lecture lecture = lectureDao.getLectureByID(Integer.parseInt(id));
				request.setAttribute("lecture", lecture);
		        RequestDispatcher view = request.getRequestDispatcher("/lecture.jsp");
		        view.forward(request, response);
		        return;
			}

		
		}else if (action.equalsIgnoreCase("payment")) {
			
		
			lectures = lectureDao.getPersonalLectures(Integer.parseInt(user_id));
			boolean isMyLecture = false;
			
			for (int i = 0; i < lectures.size(); i++) {
				if(lectures.get(i).getLecture_id() == Integer.parseInt(id)) {
					isMyLecture = true;
					break;
				}
			}
			
			if (!isMyLecture) {
				lectureDao.addMyLecture(Integer.parseInt(user_id), Integer.parseInt(id));
			}
			
			response.sendRedirect("mylecture?id=" + id);
			
		
		} else if (action.equalsIgnoreCase("delete")) {
			
			
			try {
				
				
				lectureDao.deleteLecture(Integer.parseInt(id));
				
				response.sendRedirect("admin?page=lecture");
			} catch (Exception e) {
				response.sendRedirect("adminlogin");
			}
			
			
			
			
			
		}
			
				
			
		}
		

		


}
