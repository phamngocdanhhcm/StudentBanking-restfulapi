package com.giuaki.services;

import java.util.List;

import com.giuaki.model.History;
import com.giuaki.model.Infor_User;

public interface IHistoryServices {
	void save(History history);
	List<History> findAll(Long id_pay);
	List<History> findAll_String(String id_pay);

	Long  insert(History history);
	void delete(Long[] ids);
}
