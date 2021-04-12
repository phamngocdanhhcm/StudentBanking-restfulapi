package com.giuaki.controller.web.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.giuaki.dao.impl.Infor_userDAO;
import com.giuaki.model.Infor_User;
import com.giuaki.model.Users;
import com.giuaki.services.IInfor_UserServices;
import com.giuaki.services.impl.Infor_UserServices;
import com.giuaki.utils.HttpUtils;
import com.google.gson.Gson;

@WebServlet(urlPatterns = {"/api-web-inforuser"})
public class Infor_UserAPI extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IInfor_UserServices infor_UserServices;
	
	public Infor_UserAPI() {
		infor_UserServices = new Infor_UserServices();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {      
      
	//	String id =  req.getParameter("id");
	
	    req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		Infor_User infor_user = HttpUtils.of(req.getReader()).toModel(Infor_User.class);
		Infor_User infor_user1 = new Infor_User();
		if(infor_user == null)
		{
	        String id = req.getParameter("id");
	        infor_user1 = infor_UserServices.find_inforString(id);


		}
		else {
			infor_user1 = infor_UserServices.find_infor(infor_user.getIduser());
		}
		
	    mapper.writeValue(resp.getOutputStream(), infor_user1);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		Infor_User infor_user = HttpUtils.of(req.getReader()).toModel(Infor_User.class);
		Long id = infor_UserServices.insert(infor_user);
	//	List<Infor_User> us = infor_UserServices.findAll();
		mapper.writeValue(resp.getOutputStream(), infor_user);	
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		Infor_User infor_user = HttpUtils.of(req.getReader()).toModel(Infor_User.class);
		infor_UserServices.save(infor_user);
		mapper.writeValue(resp.getOutputStream(), infor_user);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		Infor_User infor_user = HttpUtils.of(req.getReader()).toModel(Infor_User.class);
		infor_UserServices.delete(infor_user.getIds());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}
	
	
}
