package com.giuaki.services;

import java.util.List;

import com.giuaki.dao.GenericDAO;
import com.giuaki.model.Users;


public interface IUsersServices {
	boolean login(String username,String password);
	void save(Users users);
	List<Users> findAll();
	Long  insert(Users users);
	void delete(Long[] ids);
	Users find_user(String username);
}
