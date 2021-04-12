package com.giuaki.services.impl;

import java.util.List;

import javax.inject.Inject;

import com.giuaki.dao.IUsersDAO;
import com.giuaki.dao.impl.UsersDAO;
import com.giuaki.model.Users;
import com.giuaki.services.IUsersServices;

public class UsersServices implements IUsersServices {
	
	private IUsersDAO iuserDao;
	
	public UsersServices()
	{
		iuserDao = new UsersDAO();
	}
	@Override
	public boolean login(String username,String password)
	{
		
		return iuserDao.login(username, password);
	}
	
	@Override
	public void save(Users users)
	{
		iuserDao = new UsersDAO();
		Users oldusers = iuserDao.findOne(users.getUsername());
		oldusers.setPassword(users.getPassword());
		oldusers.setRole(users.getRole());
		iuserDao.save(oldusers);
	
	}
	
	@Override
	public List<Users> findAll()
	{	
		iuserDao = new UsersDAO();
		return iuserDao.findAll();
	}
	@Override
	public Long insert(Users users) {
		iuserDao = new UsersDAO();
		Long id = iuserDao.insert1(users);
		return id;
	}
	@Override
	public void delete(Long[] ids) {
		iuserDao = new UsersDAO();
		for(long id: ids)
		{
			iuserDao.delete(id);
		}
	}
	@Override
	public Users find_user(String username) {
		return iuserDao.findOne(username);
	}
}
