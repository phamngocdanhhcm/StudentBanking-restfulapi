package com.giuaki.services;

import java.util.List;

import com.giuaki.model.Infor_User;
import com.giuaki.model.Users;

public interface IInfor_UserServices {
//	boolean login(String username,String password);
	void save(Infor_User infor_user);
	List<Infor_User> findAll();
	Long  insert(Infor_User infor_user);
	void delete(Long[] ids);
	Infor_User find_infor(Long iduser);
	Infor_User find_inforString(String iduser);

}
