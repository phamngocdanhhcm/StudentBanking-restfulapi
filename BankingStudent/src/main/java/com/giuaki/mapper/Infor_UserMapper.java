package com.giuaki.mapper;

import java.sql.ResultSet;

import com.giuaki.model.Infor_User;

public class Infor_UserMapper implements RowMapper<Infor_User> {

	@Override
	public Infor_User mapRow(ResultSet rs) {
		// TODO Auto-generated method stub
		Infor_User infor_user1 = new Infor_User();
		try {
			infor_user1.setId(rs.getLong("id"));
			infor_user1.setName(rs.getString("name"));
			infor_user1.setPhone(rs.getString("phone"));
			infor_user1.setEmail(rs.getString("email"));
			infor_user1.setAddress(rs.getString("address"));
			infor_user1.setMoney(rs.getInt("money"));
			infor_user1.setIduser(rs.getLong("iduser"));
			return infor_user1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
