package com.giuaki.dao.impl;

import java.util.List;

import com.giuaki.dao.IHistoryDAO;
import com.giuaki.mapper.HistoryMapper;
import com.giuaki.mapper.OtpMapper;
import com.giuaki.model.History;
import com.giuaki.model.Otp;

public class HistoryDAO extends AbstractDAO<History> implements IHistoryDAO {

	@Override
	public List<History> findAll(Long id_pay) {
		String sql = "SELECT * FROM history where id_pay = ? order by id desc ";
		return query(sql,new HistoryMapper(),id_pay);
	}

	@Override
	public Long insert1(History history) {
		String sql = "INSERT INTO History (fullname_pay,fullname_receive,id_pay,id_receive,moneytopaid) values(?,?,?,?,?)";
		return insert(sql,history.getFullname_pay(),history.getFullname_receive(),history.getId_pay(),history.getId_receive(),history.getMoneytopaid());
	}

	@Override
	public void save(History history) {
		String sql = "UPDATE History SET fullname_pay = ? , fullname_receive = ? , id_pay = ? , id_receive = ? , moneytopaid = ?  where id = ?";
		update(sql,history.getFullname_pay(),history.getFullname_receive(),history.getId_pay(),history.getId_receive(),history.getMoneytopaid(),history.getId() );		
	}

	@Override
	public History findOne(Long id) {
		String sql = "SELECT * FROM History where id = ?";
		List<History> us = query(sql,new HistoryMapper(),id);
		return us.get(0);
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM history where id = ?";
		update(sql, id);		
	}

	@Override
	public List<History> findAll_String(String id_pay) {
		String sql = "SELECT * FROM history where id_pay = ? order by id desc ";
		return query(sql,new HistoryMapper(),id_pay);
	}

}
