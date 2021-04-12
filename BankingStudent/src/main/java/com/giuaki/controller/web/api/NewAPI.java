package com.giuaki.controller.web.api;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.giuaki.mapper.UsersMapper;
import com.giuaki.model.Users;
import com.giuaki.services.IUsersServices;
import com.giuaki.services.impl.UsersServices;
import com.giuaki.utils.HttpUtils;

@WebServlet(urlPatterns = {"/api-web-new"})
public class NewAPI extends HttpServlet {


	private IUsersServices usersService;

	public NewAPI()
	{
		usersService = new UsersServices();
	}
	
	
	private static final long serialVersionUID = -8353738330576762531L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		Users users = HttpUtils.of(req.getReader()).toModel(Users.class);
		List<Users> us  = usersService.findAll();
		Long id = usersService.insert(users);
	//	System.out.print(id);
		//boolean check = usersService.login(users.getUsername(),users.getPassword()); 
		mapper.writeValue(resp.getOutputStream(), users);
//		
	}
	
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		Users users = HttpUtils.of(req.getReader()).toModel(Users.class);
		usersService.save(users);
		mapper.writeValue(resp.getOutputStream(), users);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		Users users = HttpUtils.of(req.getReader()).toModel(Users.class);
		usersService.delete(users.getIds());
		mapper.writeValue(resp.getOutputStream(), "{}");

	}
}
