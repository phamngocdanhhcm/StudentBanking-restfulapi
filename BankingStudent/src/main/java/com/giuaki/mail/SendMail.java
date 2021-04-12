package com.giuaki.mail;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.giuaki.model.Infor_User;

import Mailer.Mailer;

@WebServlet(urlPatterns = {"/api-web-Mail"})
public class SendMail extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");;
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		HttpSession session = request.getSession();
		Infor_User infor_user = (Infor_User) session.getAttribute("Infor_user");
		
		String to = infor_user.getEmail();
		String subject = " OTP code";
		String msg ="The OTP code is : : "+ request.getParameter("otp") +". Valid within 2 minutes.";
		Mailer.send(to, subject, msg);
		mapper.writeValue(response.getOutputStream(), "message has been sent successfully");	


	}
}
