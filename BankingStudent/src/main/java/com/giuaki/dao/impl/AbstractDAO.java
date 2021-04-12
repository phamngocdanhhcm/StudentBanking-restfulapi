package com.giuaki.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.giuaki.dao.GenericDAO;
import com.giuaki.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/bankingstudent";
			String user = "root";
			String pass = "123456";
			return DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			// set parameter
			setParameters(statement,parameters);
			
			rs = statement.executeQuery();
			
			while (rs.next()) {
				results.add(rowMapper.mapRow(rs));
			}
			return results;
		} catch (SQLException e) {
			return null;
			// TODO: handle exception
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				return null;
			}
		}
	}
	
	
	
	
	private void setParameters(PreparedStatement statement,Object... parameters)
	{
		try {
			for(int i = 0 ; i < parameters.length ; i++)
			{
				Object parameter = parameters[i];
				int index = i + 1 ;
				if(parameter instanceof Long)
				{
					statement.setLong(index ,(Long) parameter);
				}
				else if(parameter instanceof String)
				{
					statement.setString(index,(String) parameter);
				}
				else if(parameter instanceof Integer)
				{
					statement.setInt(index,(int) parameter);
				}
				else if(parameter == null)
				{
					statement.setNull(index,Types.NULL);
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	@Override
	public Long insert(String sql,Object... parameters)
	{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			Long id = null;
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql,statement.RETURN_GENERATED_KEYS);
			setParameters(statement, parameters);
			statement.executeUpdate();
			rs = statement.getGeneratedKeys();
			if(rs.next())
			{
				id = rs.getLong(1);
			}
			connection.commit();
			return id;
		} catch (Exception e) {
			if(connection != null)
			{
				try {
					connection.rollback();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}

	@Override
	public void update(String sql, Object... parametes) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameters(statement, parametes);
			statement.executeUpdate();
			connection.commit();
		} catch (Exception e) {
			if(connection != null)
			{
				try {
					connection.rollback();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				
			} catch (Exception e) {
				
			}
		}
		
	}
}
