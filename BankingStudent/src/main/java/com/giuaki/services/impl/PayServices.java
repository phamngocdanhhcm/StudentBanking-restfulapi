package com.giuaki.services.impl;

import java.util.List;

import com.giuaki.dao.IPayDAO;
import com.giuaki.dao.impl.PayDAO;
import com.giuaki.model.Pay;
import com.giuaki.services.IPayServices;

public class PayServices implements IPayServices {
	private IPayDAO payDAO;
	
	public PayServices() {
		payDAO = new PayDAO();
	}
	
	@Override
	public void save(Pay pay) {
		Pay newPay = new Pay();
		newPay.setId_ifuser(pay.getId_ifuser());
		newPay.setMoneytopaid(pay.getMoneytopaid());
		newPay.setStatus(pay.getStatus());
		payDAO.save(newPay);
	}

	@Override
	public List<Pay> findAll() {
		return payDAO.findAll();
	}

	@Override
	public Long insert(Pay pay) {
		return payDAO.insert1(pay);
	}

	@Override
	public void delete(Long[] ids) {
		for(Long id:ids)
		{
			payDAO.delete(id);
		}
	}

	@Override
	public Pay find_payString(String id) {
		// TODO Auto-generated method stub
		return payDAO.find_payString(id);
	}

	@Override
	public Pay find_pay(Long id) {
		// TODO Auto-generated method stub
		return payDAO.findOne(id);
	}

}
