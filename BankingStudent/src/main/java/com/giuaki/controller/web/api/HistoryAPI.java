package com.giuaki.controller.web.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.giuaki.model.History;
import com.giuaki.model.Infor_User;
import com.giuaki.services.IHistoryServices;
import com.giuaki.services.impl.HistoryServices;
import com.giuaki.utils.HttpUtils;

@WebServlet(urlPatterns = {"/api-web-History"})
public class HistoryAPI extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private IHistoryServices historyServices;
	
	public HistoryAPI()
	{
		historyServices = new HistoryServices();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		History history = HttpUtils.of(req.getReader()).toModel(History.class);
		List<History> history1 = new ArrayList<History>();
		if(history == null)
		{
			String id_pay =  req.getParameter("id_pay");
			history1 = historyServices.findAll_String(id_pay);
			mapper.writeValue(resp.getOutputStream(), history1);
		}
		else
		{
			history1 = historyServices.findAll(history.getId_pay());
			if(history1 == null)
			{
				mapper.writeValue(resp.getOutputStream(),"{\"check\":\"fail\"}");	
			}
			else {
				mapper.writeValue(resp.getOutputStream(), history1);
			}
		}
	//	List<History> us = historyServices.findAll();
			
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		History history = HttpUtils.of(req.getReader()).toModel(History.class);
		Long id = historyServices.insert(history);
	//	List<History> us = historyServices.findAll();
		mapper.writeValue(resp.getOutputStream(), history);	
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		History history = HttpUtils.of(req.getReader()).toModel(History.class);
		historyServices.save(history);
		mapper.writeValue(resp.getOutputStream(), history);	

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		History history = HttpUtils.of(req.getReader()).toModel(History.class);
		historyServices.delete(history.getIds());
		mapper.writeValue(resp.getOutputStream(), history);	

	}
}
