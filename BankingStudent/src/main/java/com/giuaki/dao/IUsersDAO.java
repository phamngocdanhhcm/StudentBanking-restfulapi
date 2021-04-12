package com.giuaki.dao;

import java.util.List;

import com.giuaki.model.Users;

public interface IUsersDAO extends GenericDAO<Users> {
	List<Users> findAll();
	boolean login(String username,String password);
	Long insert1(Users users);
	void save(Users users);
	Users findOne(String username);
	void delete(Long id);
}
