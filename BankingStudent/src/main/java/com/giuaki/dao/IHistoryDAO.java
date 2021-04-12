package com.giuaki.dao;

import java.util.List;

import com.giuaki.model.History;

public interface IHistoryDAO extends GenericDAO<History> {
	List<History> findAll(Long id_pay);
	List<History> findAll_String(String id_pay);

	Long insert1(History history);
	void save(History history);
	History findOne(Long id);
	void delete(Long id);
}
