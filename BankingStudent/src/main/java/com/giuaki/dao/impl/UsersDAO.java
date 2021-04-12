package com.giuaki.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.giuaki.dao.IUsersDAO;
import com.giuaki.mapper.UsersMapper;
import com.giuaki.model.Users;

//implements IUsersDAO
public class UsersDAO extends AbstractDAO<Users> implements IUsersDAO  {
	

	
	/*	@Override
	public boolean login(String username,String password)
	{
		String sql = "Select * from user";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				while(resultSet.next())
				{
					if(username.equals(resultSet.getString("username")) && password.equals(resultSet.getString("password")))
					{
						return true;
					}
					
				}
				if(connection != null)
				{
					connection.close();
				}
				if(statement != null)
				{
					statement.close();
				}
				if(resultSet != null)
				{
					resultSet.close();
				}
			} catch (Exception e) {
				return false;
			}
		} 
		return false;
	}*/
	
	@Override
	public List<Users> findAll(){
		String sql = "SELECT * FROM user ";
		return query(sql,new UsersMapper());
	}
	
	@Override
	public Users findOne(String username){
		String sql = "SELECT * FROM user where username = ?";
		List<Users> us = query(sql,new UsersMapper(),username);
		return query(sql,new UsersMapper(),username).get(0);
	}

	
	@Override
	public boolean login(String username,String password)
	{
		try {
			Users user = findOne(username);
			if(user.getUsername().equals(username) && user.getPassword().equals(password))
			{
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;

	}

	@Override
	public Long insert1(Users users) {
		String sql = "INSERT INTO user (username,password,role) values(?,?,?)";
		return insert(sql,users.getUsername(),users.getPassword(),users.getRole());
	}

	@Override
	public void save(Users users) {
		String sql = "UPDATE user SET password = ? , role = ? where username = ?";
		update(sql, users.getPassword(),users.getRole(),users.getUsername());
		
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM user where id = ?";
		update(sql, id);
	}
	
	
	/*	
	@Override
	public Long save(Users user)
	{
		String sql = "INSERT INTO user(id,username,password,role) VALUES(?,?,?,?)";
		return insert(sql, user.getId(),user.getUsername(),user.getPassword(),user.getRole());
	}*/

}
