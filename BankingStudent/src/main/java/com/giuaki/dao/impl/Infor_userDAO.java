package com.giuaki.dao.impl;

import java.util.List;

import com.giuaki.dao.IInfor_userDAO;
import com.giuaki.mapper.Infor_UserMapper;
import com.giuaki.mapper.UsersMapper;
import com.giuaki.model.Infor_User;
import com.giuaki.model.Users;

public class Infor_userDAO extends AbstractDAO<Infor_User> implements IInfor_userDAO {

	@Override
	public List<Infor_User> findAll() {
		String sql = "SELECT * FROM infor_user ";
		return query(sql,new Infor_UserMapper());
	}

	@Override
	public Long insert1(Infor_User infor_user) {
		String sql = "INSERT INTO Infor_User (name,phone,email,address,money,iduser) values(?,?,?,?,?,?)";
		return insert(sql,infor_user.getName(),infor_user.getPhone(),infor_user.getEmail(),infor_user.getAddress(),infor_user.getMoney(),infor_user.getIduser());
	}

	@Override
	public void save(Infor_User infor_user) {
		String sql = "UPDATE infor_user SET name = ? , phone = ? , email = ? , address = ?, money = ? where id = ?";
		update(sql, infor_user.getName(),infor_user.getPhone(),infor_user.getEmail(),infor_user.getAddress(),infor_user.getMoney(),infor_user.getId());
	}

	@Override
	public Infor_User findOne(Long id) {
		String sql = "SELECT * FROM infor_user where iduser = ?";
		List<Infor_User> us = query(sql,new Infor_UserMapper(),id);
		return query(sql,new Infor_UserMapper(),id).get(0);
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM infor_user where id = ?";
		update(sql, id);		
	}

	@Override
	public Infor_User findOneString(String id) {
		String sql = "SELECT * FROM infor_user where id = ?";
		List<Infor_User> us = query(sql,new Infor_UserMapper(),id);
		return query(sql,new Infor_UserMapper(),id).get(0);
	}

}
