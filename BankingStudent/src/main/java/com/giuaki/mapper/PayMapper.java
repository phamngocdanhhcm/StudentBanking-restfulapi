package com.giuaki.mapper;

import java.sql.ResultSet;

import com.giuaki.model.Pay;

public class PayMapper implements RowMapper<Pay> {

	@Override
	public Pay mapRow(ResultSet rs) {
		Pay pay = new Pay();
		try {
			pay.setId(rs.getLong("id"));
			pay.setId_ifuser(rs.getLong("id_ifuser"));
			pay.setMoneytopaid(rs.getInt("moneytopaid"));
			pay.setStatus(rs.getInt("status"));
			return pay;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
