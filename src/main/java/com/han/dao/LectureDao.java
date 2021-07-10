package com.han.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.han.model.Lecture;
import com.han.model.User;
import com.han.util.DBUtil;


public class LectureDao {

	private SqlSession sqlSession;

	public LectureDao() {

	}
	
	public List<Lecture> getAllLectures () {
		sqlSession = DBUtil.getSqlSession();
		List<Lecture> lectures = new ArrayList<Lecture>();
		
		try {
			lectures = sqlSession.selectList("LectureMapper.getAllLectures");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return lectures;
		

	}
	
	public Lecture getLectureByID (@Param("lecture_id") int lecture_id) {
		sqlSession = DBUtil.getSqlSession();
		Lecture lecture = new Lecture();
		
		try {
			lecture = sqlSession.selectOne("LectureMapper.getLectureByID", lecture_id);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return lecture;
		

	}
	
	
	public List<Lecture> getPersonalLectures (@Param("user_id") int user_id) {
		sqlSession = DBUtil.getSqlSession();
		List<Lecture> lectures = new ArrayList<Lecture>();
		
		try {
			lectures = sqlSession.selectList("LectureMapper.getPersonalLectures", user_id);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return lectures;
		

	}
	
	public void addMyLecture (@Param("user_id") int user_id, @Param("lecture_id") int lecture_id) {
		
		sqlSession = DBUtil.getSqlSession();
		try {
				HashMap<String, Integer> map = new HashMap<String, Integer>();
				map.put("user_id", user_id);
				map.put("lecture_id", lecture_id);
			
				sqlSession.insert("LectureMapper.addMyLecture", map);
				sqlSession.commit();	

				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		

	}
	
public void addLecture (@Param("lecture") Lecture lecture) {
		
		sqlSession = DBUtil.getSqlSession();
		try {
				sqlSession.insert("LectureMapper.addLecture", lecture);
				sqlSession.commit();	

				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		

	}


public void deleteLecture (@Param("lecture_id") int lecture_id) {
	sqlSession = DBUtil.getSqlSession();

	try {
		sqlSession.delete("LectureMapper.deleteLecture", lecture_id);
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		sqlSession.close();
	}
	
	

}

	

}
