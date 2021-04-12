package com.giuaki.dao;

import java.util.List;

import com.giuaki.model.Infor_User;
import com.giuaki.model.Otp;

public interface IOtpDAO {
	List<Otp> findAll();
//	boolean login(String username,String password);
	Long insert1(Otp otp);
	void save(Otp otp);
	Otp findOne(String otp);
	void delete(Long id);
}
