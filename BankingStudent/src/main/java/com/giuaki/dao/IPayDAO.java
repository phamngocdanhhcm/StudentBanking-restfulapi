package com.giuaki.dao;

import java.util.List;

import com.giuaki.model.Otp;
import com.giuaki.model.Pay;

public interface IPayDAO {
	List<Pay> findAll();
//	boolean login(String username,String password);
	Long insert1(Pay pay);
	void save(Pay pay);
	Pay findOne(Long pay);
	void delete(Long id);
	Pay find_payString(String id);
}
