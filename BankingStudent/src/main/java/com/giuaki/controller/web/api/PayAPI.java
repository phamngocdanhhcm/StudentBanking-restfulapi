package com.giuaki.controller.web.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.giuaki.model.Infor_User;
import com.giuaki.model.Pay;
import com.giuaki.services.IPayServices;
import com.giuaki.services.impl.PayServices;
import com.giuaki.utils.HttpUtils;
import com.giuaki.utils.SessionUtils;
import com.google.gson.Gson;

@WebServlet(urlPatterns = {"/api-web-Pay"})
public class PayAPI extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	
	public IPayServices payServices;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
//		Pay pay = HttpUtils.of(req.getReader()).toModel(Pay.class);
		String id =  req.getParameter("id");
	    Pay pay1 = payServices.find_payString(id);
	    if(pay1 == null)
	    {
	    	Gson gson = new Gson();
		    String json = gson.toJson(null);
		    out.write(json);
		    out.flush();
	    }
	    else {
	    	Gson gson = new Gson();
		    String json = gson.toJson(pay1);
		    out.write(json);
		    out.flush();
	    }
//	    Pay pay2 = payServices.find_pay(pay.getId_ifuser());
	    
	//    mapper.writeValue(resp.getOutputStream(), pay2);	
	}
	
	
	public PayAPI()
	{
		payServices = new PayServices();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		Infor_User infor_user = (Infor_User) SessionUtils.getInstance().getValue(req, "Infor_user");	
		ObjectMapper mapper = new ObjectMapper();
		Pay pay = HttpUtils.of(req.getReader()).toModel(Pay.class);
		Long id = payServices.insert(pay);
		mapper.writeValue(resp.getOutputStream(), pay);

	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		Pay pay = HttpUtils.of(req.getReader()).toModel(Pay.class);
		payServices.save(pay);
		mapper.writeValue(resp.getOutputStream(), pay);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		Pay pay = HttpUtils.of(req.getReader()).toModel(Pay.class);
		payServices.delete(pay.getIds());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}

}
