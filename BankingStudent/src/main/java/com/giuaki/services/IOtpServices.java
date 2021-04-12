package com.giuaki.services;

import java.util.List;

import com.giuaki.model.Infor_User;
import com.giuaki.model.Otp;

public interface IOtpServices {
	void save(Otp otp);
	List<Otp> findAll();
	Long  insert(Otp otp);
	void delete(Long ids);
}
