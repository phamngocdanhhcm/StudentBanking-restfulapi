package com.giuaki.controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet( urlPatterns = {"/Otp"})
public class OtpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public OtpController() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String action = request.getParameter("moneytopaid");
	request.setAttribute("money", action);
	String id_user = request.getParameter("id");
	request.setAttribute("idpay", id_user);
	String name_receive = request.getParameter("name_receive");
	request.setAttribute("name_receive", name_receive);
	RequestDispatcher rd = request.getRequestDispatcher("/views/web/Otp.jsp");
	rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
