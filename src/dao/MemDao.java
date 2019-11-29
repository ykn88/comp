package dao;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojo.Member;
import utils.MemUtils;

public class MemDao implements Closeable  
{
	private Connection connection;
	private PreparedStatement selectStatement;
	private PreparedStatement findStatement;
	
	public MemDao () throws Exception
	{
		this.connection = MemUtils.getConnection();
		this.selectStatement = connection.prepareStatement("select  name, author, subject, price, status from books b inner join copies c on b.id = c.bookid");
		this.findStatement = connection.prepareStatement("select  name, author, subject, price, status from books b inner join copies c on b.id = c.bookid where name = ?");
	}
	
	public List<Member> getBooks()throws Exception
	{
		List<Member> bookList = new ArrayList<Member>();
		try( ResultSet rs = this.selectStatement.executeQuery())
		{
			while( rs.next())
			{
				Member book = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5));
				bookList.add(book);
			}
		}
		return bookList;
	}
	
	public List<Member> findBooks(String name)throws Exception
	{
		
		this.findStatement.setString(1, name);
		List<Member> bookList = new ArrayList<Member>();
		try( ResultSet rs = this.findStatement.executeQuery())
		{
			while( rs.next())
			{
				Member book = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5));
				bookList.add(book);
			}
		}
		return bookList;
	}
	
	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
