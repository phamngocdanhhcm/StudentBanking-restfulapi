package com.giuaki.dao.impl;

import java.util.List;

import com.giuaki.dao.IOtpDAO;
import com.giuaki.mapper.Infor_UserMapper;
import com.giuaki.mapper.OtpMapper;
import com.giuaki.model.Infor_User;
import com.giuaki.model.Otp;

public class OtpDAO extends AbstractDAO<Otp> implements IOtpDAO {

	@Override
	public List<Otp> findAll() {
		String sql = "SELECT * FROM otp ";
		return query(sql,new OtpMapper());
	}

	@Override
	public Long insert1(Otp otp) {
		String sql = "INSERT INTO Otp (id_pay,status,iduserpay,otp) values(?,?,?,?)";
		return insert(sql,otp.getId_pay(),otp.getStatus(),otp.getIduserpay(),otp.getOtp());
	}

	@Override
	public void save(Otp otp) {
		String sql = "UPDATE Otp SET status = 1 where id_pay = ? and otp = ?";
		update(sql,otp.getId_pay(),otp.getOtp());
		
	}

	@Override
	public Otp findOne(String otp) {
		String sql = "SELECT * FROM otp where otp = ?";
		List<Otp> us = query(sql,new OtpMapper(),otp);
		return us.get(0);
	}

	@Override
	public void delete(Long id_pay) {
		String sql = "DELETE FROM otp where id_pay = ? and status = 0";
		update(sql, id_pay);		
		
	}

}
