package com.giuaki.mapper;

import java.sql.ResultSet;

import com.giuaki.model.Otp;

public class OtpMapper implements RowMapper<Otp> {

	@Override
	public Otp mapRow(ResultSet rs) {
		Otp otp = new Otp();
		try {
			otp.setId_pay(rs.getLong("id_pay"));
			otp.setStatus(rs.getInt("status"));
			otp.setIduserpay(rs.getLong("iduserpay"));
			otp.setOtp(rs.getInt("otp"));
			return otp;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
