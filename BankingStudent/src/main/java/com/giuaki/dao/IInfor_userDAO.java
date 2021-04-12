package com.giuaki.dao;

import java.util.List;

import com.giuaki.model.Infor_User;
import com.giuaki.model.Users;

public interface IInfor_userDAO extends GenericDAO<Infor_User> {
	List<Infor_User> findAll();
//	boolean login(String username,String password);
	Long insert1(Infor_User infor_user);
	void save(Infor_User infor_user);
	Infor_User findOne(Long id);
	Infor_User findOneString(String id);

	void delete(Long id);
	
}
