package com.giuaki.dao.impl;

import java.util.List;

import com.giuaki.dao.IPayDAO;
import com.giuaki.mapper.OtpMapper;
import com.giuaki.mapper.PayMapper;
import com.giuaki.model.Otp;
import com.giuaki.model.Pay;

public class PayDAO extends AbstractDAO<Pay> implements IPayDAO {

	@Override
	public List<Pay> findAll() {
		String sql = "SELECT * FROM pay ";
		return query(sql,new PayMapper());	}

	@Override
	public Long insert1(Pay pay) {
		String sql = "INSERT INTO pay (id_ifuser,moneytopaid,status) values(?,?,?)";
		return insert(sql,pay.getId_ifuser(),pay.getMoneytopaid(),pay.getStatus());
	}

	@Override
	public void save(Pay pay) {
		String sql = "UPDATE Pay SET status = 1 where id_ifuser = ? and  moneytopaid = ? and status = ?";
		update(sql,pay.getId_ifuser(),pay.getMoneytopaid(), 0);
		
	}

	@Override
	public Pay findOne(Long id) {
		String sql = "SELECT * FROM pay where id_ifuser = ?";
		List<Pay> us = query(sql,new PayMapper(),id);
		return us.get(0);
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM pay where id = ?";
		update(sql, id);	
		
	}

	@Override
	public Pay find_payString(String id) {
		String sql = "SELECT * FROM pay where id_ifuser = ? and status = 0";
		List<Pay> us = query(sql,new PayMapper(),id);
		if(us.isEmpty()) {
			return null;
		}
		return us.get(0);
	}

}
