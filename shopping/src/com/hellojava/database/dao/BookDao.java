package com.hellojava.database.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gellojava.web.entity.Book;
import com.hellojava.database.DBManager;

public class BookDao extends DBManager{
	/**
	 * 
	 * @param page
	 * @param displayCount
	 * @return
	 * @throws SQLException
	 */
	public List<Book> loadAll(int page,int displayCount)throws SQLException{
		List<Book> list=new ArrayList<>();
		Connection conn=this.openConnection();
		String sql="select * from book limit ?,?";
		Object[] obs= {page*displayCount,displayCount};
		ResultSet rs=this.query(conn, sql, obs);
		while(rs.next()) {
			Book b=new Book();
			b.setBookId(rs.getInt("bookId"));
			b.setBookName(rs.getString("bookName"));
			b.setBookAuthor(rs.getString("bookAuthor"));
			b.setBookPrice(rs.getDouble("bookPrice"));
			b.setBookInfo(rs.getString("bookInfo"));
			
			list.add(b);
		}
		this.closeConnection();
		return list;
	}
	
	public int getTotalCount()throws SQLException{
		int count=0;
		Connection conn=this.openConnection();
		String sql="select count(bookId) from book";
		ResultSet rs=this.query(conn, sql, null);
		if(rs.next()) {
			count=rs.getInt(1);
		}
		this.closeConnection();
		return count;
	}
	
	private String concatShoppingSql(String...ids) {
		String sql="select * from book where bookId in(";
		if(ids!=null && ids.length>0) {
			for (int i = 0; i < ids.length; i++) {
				sql+=i==ids.length-1?ids[i]:ids[i]+",";				
			}
		}
		sql+=")";
		return sql;
	}
	
	public List<Book> loadShopping(String...ids)throws SQLException{
		List<Book> shopping=new ArrayList<>();
		Connection conn=this.openConnection();
		String sql=concatShoppingSql(ids);
		ResultSet rs=this.query(conn, sql, null);
		while(rs.next()) {
			Book b=new Book();
			b.setBookId(rs.getInt("bookId"));
			b.setBookName(rs.getString("bookName"));
			b.setBookAuthor(rs.getString("bookAuthor"));
			b.setBookPrice(rs.getDouble("bookPrice"));
			b.setBookInfo(rs.getString("bookInfo"));
			shopping.add(b);
		}
		this.closeConnection();
		return shopping;
	}
}
