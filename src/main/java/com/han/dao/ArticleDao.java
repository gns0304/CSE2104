package com.han.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.han.model.Article;
import com.han.model.Lecture;
import com.han.util.DBUtil;

public class ArticleDao {

	private SqlSession sqlSession;
	
	public void addArticle (@Param("article") Article article) {
			
		
		
			sqlSession = DBUtil.getSqlSession();
			try {
					sqlSession.insert("ArticleMapper.addArticle", article);
					sqlSession.commit();	
	
					
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sqlSession.close();
			}
	
			
	
		}
	
	public void updateArticle (@Param("article") Article article) {
		
		
		
		sqlSession = DBUtil.getSqlSession();
		try {
				sqlSession.update("ArticleMapper.updateArticle", article);
				sqlSession.commit();	

				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		

	}
	
	
	public Article getArticle(@Param("article_id") int article_id) {
		
		sqlSession = DBUtil.getSqlSession();
		Article article = null;
		
		try {
			article = sqlSession.selectOne("ArticleMapper.getArticle", article_id);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return article;
		

	}
	
	public int getWriter(@Param("article_id") int article_id) {
		
		sqlSession = DBUtil.getSqlSession();
		int user_id = 0;
		
		try {
			user_id = sqlSession.selectOne("ArticleMapper.getWriter", article_id);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return user_id;
		

	}
	
	public void deleteArticle (@Param("article_id") int article_id) {
		sqlSession = DBUtil.getSqlSession();

		try {
			sqlSession.delete("ArticleMapper.deleteArticle", article_id);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	
}
	
	public List<Article> getAllArticles () {
		sqlSession = DBUtil.getSqlSession();
		List<Article> articles = new ArrayList<Article>();
		
		try {
			articles = sqlSession.selectList("ArticleMapper.getAllArticles");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return articles;
		

	}
}