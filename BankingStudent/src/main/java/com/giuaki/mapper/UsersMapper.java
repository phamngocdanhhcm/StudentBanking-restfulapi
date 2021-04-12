package com.giuaki.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.giuaki.model.Users;

public class UsersMapper implements RowMapper<Users> {

	@Override
	public Users mapRow(ResultSet rs) {
		// TODO Auto-generated method stub
		Users users = new Users();
		try {
			users.setId(rs.getLong("id"));
			users.setUsername(rs.getString("username"));
			users.setPassword(rs.getString("password"));
			users.setRole(rs.getInt("role"));
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
