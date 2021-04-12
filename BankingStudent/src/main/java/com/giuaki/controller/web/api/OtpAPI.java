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
import com.giuaki.model.Otp;
import com.giuaki.services.IOtpServices;
import com.giuaki.services.impl.OtpServices;
import com.giuaki.utils.HttpUtils;
import com.giuaki.utils.SessionUtils;
import com.google.gson.Gson;

@WebServlet(urlPatterns = {"/api-web-Otp"})
public class OtpAPI extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public IOtpServices otpServices;
	
	public OtpAPI()
	{
		otpServices = new OtpServices();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
	//	PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
	//	Gson gson = new Gson();
		ObjectMapper mapper = new ObjectMapper();
		Otp otp = HttpUtils.of(req.getReader()).toModel(Otp.class);
		SessionUtils.getInstance().putValue(req, "Otp", otp);

		List<Otp> us  = otpServices.findAll();
//		Long id = otpServices.insert(otp);
//		mapper.writeValue(resp.getOutputStream(), otp);
		int check = 0;
		for (Otp otp2 : us) {
			if(otp2.getId_pay().equals(otp.getId_pay()) && otp2.getStatus() == 0 )
			{
				 check = check + 1 ;
			}
		}
		if(check==0)
		{
			Long id = otpServices.insert(otp);
			mapper.writeValue(resp.getOutputStream(), id);
		}
		else {
			Long id1 = null ;
			mapper.writeValue(resp.getOutputStream(), id1);
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		Otp otp = HttpUtils.of(req.getReader()).toModel(Otp.class);
		otpServices.save(otp);
		SessionUtils.getInstance().removeValue(req, "Otp");
		mapper.writeValue(resp.getOutputStream(), otp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		Otp otp = HttpUtils.of(req.getReader()).toModel(Otp.class);
		otpServices.delete(otp.getId_pay());
		SessionUtils.getInstance().removeValue(req, "Otp");
		mapper.writeValue(resp.getOutputStream(), "{}");
	}
}
