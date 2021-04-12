package com.giuaki.services.impl;

import java.util.List;

import com.giuaki.dao.IOtpDAO;
import com.giuaki.dao.impl.OtpDAO;
import com.giuaki.model.Otp;
import com.giuaki.services.IOtpServices;

public class OtpServices implements IOtpServices {
	private IOtpDAO otpDAO;
	
	public OtpServices()
	{
		otpDAO = new OtpDAO();
	}

	@Override
	public void save(Otp otp) {
		Otp newOtp = new Otp();
		newOtp.setId(otp.getId());
		newOtp.setId_pay(otp.getId_pay());
		newOtp.setIduserpay(otp.getIduserpay());
		newOtp.setOtp(otp.getOtp());
		newOtp.setStatus(otp.getStatus());
		otpDAO.save(newOtp);
		
	}

	@Override
	public List<Otp> findAll() {
		return otpDAO.findAll();
	}

	@Override
	public Long insert(Otp otp) {
		return otpDAO.insert1(otp);
	}

	@Override
	public void delete(Long id_pay) {
		
			otpDAO.delete(id_pay);
	}
	
	

}
