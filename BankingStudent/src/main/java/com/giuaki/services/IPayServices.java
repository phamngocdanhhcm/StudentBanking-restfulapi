package com.giuaki.services;

import java.util.List;

import com.giuaki.model.Pay;

public interface IPayServices {
	void save(Pay pay);
	List<Pay> findAll();
	Long  insert(Pay pay);
	void delete(Long[] ids);
	Pay find_payString(String id);
	Pay find_pay(Long id);

}
