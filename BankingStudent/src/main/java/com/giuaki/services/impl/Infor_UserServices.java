package com.giuaki.services.impl;

import java.util.List;

import com.giuaki.dao.IInfor_userDAO;
import com.giuaki.dao.impl.Infor_userDAO;
import com.giuaki.mapper.RowMapper;
import com.giuaki.model.Infor_User;
import com.giuaki.services.IInfor_UserServices;

public class Infor_UserServices implements IInfor_UserServices {
	private IInfor_userDAO infor_userDAO;
	
	 public Infor_UserServices() {
		infor_userDAO = new Infor_userDAO();
	}
	
	@Override
	public void save(Infor_User infor_user) {
		Infor_User new_infuser = new Infor_User();
		new_infuser.setId(infor_user.getId());
		new_infuser.setIds(infor_user.getIds());
		new_infuser.setName(infor_user.getName());
		new_infuser.setEmail(infor_user.getEmail());
		new_infuser.setMoney(infor_user.getMoney());
		new_infuser.setPhone(infor_user.getPhone());
		new_infuser.setAddress(infor_user.getAddress());
		infor_userDAO.save(new_infuser);
	}

	@Override
	public List<Infor_User> findAll() {
		
		return infor_userDAO.findAll();
	}

	@Override
	public Long insert(Infor_User infor_user) {
		return infor_userDAO.insert1(infor_user);
	}

	@Override
	public void delete(Long[] ids) {
		for(Long id:ids)
		{
			infor_userDAO.delete(id);
		}
	}

	@Override
	public Infor_User find_infor(Long iduser) {
		return infor_userDAO.findOne(iduser);
	}

	@Override
	public Infor_User find_inforString(String iduser) {
		// TODO Auto-generated method stub
		return infor_userDAO.findOneString(iduser);
	}
	
	
	
}
