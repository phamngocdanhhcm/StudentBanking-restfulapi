package com.giuaki.services.impl;

import java.util.List;

import com.giuaki.dao.IHistoryDAO;
import com.giuaki.dao.impl.HistoryDAO;
import com.giuaki.model.History;
import com.giuaki.services.IHistoryServices;

public class HistoryServices implements IHistoryServices {
	private IHistoryDAO historyDAO;
	
	public HistoryServices() {
		historyDAO = new HistoryDAO();
	}
	
	@Override
	public void save(History history) {
		History newHistory = new History();
		newHistory.setId(history.getId());
		newHistory.setFullname_pay(history.getFullname_pay());
		newHistory.setFullname_receive(history.getFullname_receive());
		newHistory.setId_pay(history.getId_pay());
		newHistory.setId_receive(history.getId_receive());
		historyDAO.save(newHistory);
	}

	@Override
	public List<History> findAll(Long id_pay) {
		return historyDAO.findAll(id_pay);
	}

	@Override
	public Long insert(History history) {
		return historyDAO.insert1(history);
	}

	@Override
	public void delete(Long[] ids) {
		for(Long id:ids)
		{
			historyDAO.delete(id);
		}
	}

	@Override
	public List<History> findAll_String(String id_pay) {
		return historyDAO.findAll_String(id_pay);
	}

}
