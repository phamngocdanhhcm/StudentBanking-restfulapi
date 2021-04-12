package com.giuaki.mapper;

import java.sql.ResultSet;

import com.giuaki.model.History;

public class HistoryMapper implements RowMapper<History> {

	@Override
	public History mapRow(ResultSet rs) {
		History history = new History();
		try {
			history.setId(rs.getLong("id"));
			history.setId_pay(rs.getLong("id_pay"));
			history.setFullname_pay(rs.getString("fullname_pay"));
			history.setFullname_receive(rs.getString("fullname_receive"));
			history.setId_receive(rs.getLong("id_receive"));
			history.setMoneytopaid(rs.getInt("moneytopaid"));
			return history;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
