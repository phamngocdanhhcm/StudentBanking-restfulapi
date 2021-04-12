package com.giuaki.controller.web;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.giuaki.dao.IUsersDAO;
import com.giuaki.dao.impl.UsersDAO;
import com.giuaki.model.Infor_User;
import com.giuaki.model.Users;
import com.giuaki.services.IInfor_UserServices;
import com.giuaki.services.IUsersServices;
import com.giuaki.services.impl.Infor_UserServices;
import com.giuaki.services.impl.UsersServices;
import com.giuaki.utils.FormUtils;
import com.giuaki.utils.SessionUtils;

@WebServlet(urlPatterns =  {"/trang-chu","/dang-nhap","/logout"})
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 5439788752719642875L;

	public IUsersServices usersServices;
	
	public IInfor_UserServices infor_UserServices;
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	
	public HomeController()
	{
		usersServices = new UsersServices();
		infor_UserServices = new Infor_UserServices();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action =req.getParameter("action");
		if(action != null && action.equals("login"))
		{
			String message = req.getParameter("message");
			if(message !=null )
			{
				req.setAttribute("message", resourceBundle.getString(message));
			}
			RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
			rd.forward(req, resp);
		}
		else if(action != null && action.equals("logout"))
		{
			SessionUtils.getInstance().removeValue(req, "Users");
			resp.sendRedirect(req.getContextPath()+"/trang-chu");
		}
		else if(action != null && action.equals("trangchu"))
		{
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/TrangChu.jsp");
			rd.forward(req, resp);
		}
		else {
			Long id = 1L;
			RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
			rd.forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action != null && action.equals("login"))
		{
			Users user = FormUtils.toModel(Users.class, req);

			
			if(usersServices.login(user.getUsername(), user.getPassword()) == true)
			{
				Users full_user = usersServices.find_user(user.getUsername());
				Infor_User infor_user = infor_UserServices.find_infor(full_user.getId());
				SessionUtils.getInstance().putValue(req, "Infor_user", infor_user);
				RequestDispatcher rd = req.getRequestDispatcher("/views/web/TrangChu.jsp");
				rd.forward(req, resp);
			}
			else
			{
				resp.sendRedirect(req.getContextPath()+"/dang-nhap?action=login&message=username_password_invalid");
			}
		}
	}
}
