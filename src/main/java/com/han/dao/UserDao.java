package com.han.dao;



import java.util.HashMap;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;


 
import com.han.util.DBUtil;
import com.han.model.User;

public class UserDao {

	private SqlSession sqlSession;
	
	public UserDao() {
		
	}
	
	public User getUserByID(@Param("user_id") int user_id) {
		
		sqlSession = DBUtil.getSqlSession();
		User user = null;
		
		try {
			user = sqlSession.selectOne("UserMapper.getUserbyId", user_id);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return user;
		

	}
	// ID, PW 사용자 확인
	public User getUser(@Param("id") String id, @Param("password") String password){
		sqlSession = DBUtil.getSqlSession();
		User user = null;
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("password", password);
			
		try {
			user = sqlSession.selectOne("UserMapper.getUser", map);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return user;
		

	}
	
	public void addUser(@Param("user") User user){
		
		sqlSession = DBUtil.getSqlSession();
		try {
			sqlSession.insert("UserMapper.addUser", user);
			sqlSession.commit();

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		

	}
	
	public void deleteUser(@Param("user_id") int user_id){
		sqlSession = DBUtil.getSqlSession();
		
		try {
			sqlSession.delete("UserMapper.deleteUser", user_id);
			sqlSession.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		

	}
	
	public void editUser(@Param("user") User user){
		
		sqlSession = DBUtil.getSqlSession();
		try {
			sqlSession.update("UserMapper.editUser", user);
			sqlSession.commit();

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}


	}
	
}
